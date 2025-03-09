package com.example.ConnectUs.controller;

import com.example.ConnectUs.dto.response.userImage.UserImageResponseDto;
import com.example.ConnectUs.service.UserImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/connectus/userimage")
public class UserImageController {
    private final UserImageService userImageService;

    public UserImageController(UserImageService userImageService) {
        this.userImageService = userImageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<UserImageResponseDto> uploadImage(@RequestParam("image") MultipartFile multipartFile, @RequestParam int userId) throws IOException {
        UserImageResponseDto response = userImageService.uploadImage(multipartFile,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/fetchImage/{userId}")
    public ResponseEntity<byte[]> fetchImage(@PathVariable int userId){
        byte[] image = userImageService.fetchImage(userId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
