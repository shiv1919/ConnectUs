package com.example.ConnectUs.security;

import com.example.ConnectUs.entity.User;
import com.example.ConnectUs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByUseremail(email);
        return new org.springframework.security.core.userdetails.User(user.getUseremail(), user.getPassword(), new ArrayList<>());
    }
}