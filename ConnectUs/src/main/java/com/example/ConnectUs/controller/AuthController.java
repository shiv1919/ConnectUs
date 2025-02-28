package com.example.ConnectUs.controller;

import com.example.ConnectUs.dto.request.LoginRequestDto;
import com.example.ConnectUs.dto.request.RegisterRequestDto;
import com.example.ConnectUs.entity.User;
import com.example.ConnectUs.security.JwtUtil;
import com.example.ConnectUs.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/connectus/auth")
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager,  JwtUtil jwtUtil, PasswordEncoder passwordEncoder, UserRepository userRepositry) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepositry;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDto loginRequestDto)  {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword())
            );

            String token = jwtUtil.generateToken(
                    loginRequestDto.getEmail(),
                    userRepository.findByEmail(loginRequestDto.getEmail()).getId(),
                    userRepository.findByEmail(loginRequestDto.getEmail()).getName() + " " +
                            userRepository.findByEmail(loginRequestDto.getEmail()).getLastName()
            );

            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid email or password"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequestDto registerRequestDto){
        try {
            if (userRepository.findByEmail(registerRequestDto.getEmail()) != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("error", "Email already exists"));
            }
            User user = new User();
            user.setEmail(registerRequestDto.getEmail());
            user.setName(registerRequestDto.getName());
            user.setLastName(registerRequestDto.getLastName());
            user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));

            userRepository.save(user);
            String token = jwtUtil.generateToken(
                    user.getEmail(),
                    user.getId(),
                    user.getName() + " " + user.getLastName()
            );
            return ResponseEntity.ok(Map.of(
                    "message", "Registration successful",
                    "token", token
            ));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Registration failed"));
        }
    }

}
