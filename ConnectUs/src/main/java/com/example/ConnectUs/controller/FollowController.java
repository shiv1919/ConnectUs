package com.example.ConnectUs.controller;

import com.example.ConnectUs.dto.request.FollowRequestDto;
import com.example.ConnectUs.service.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connectus/follows")
public class FollowController {
    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody FollowRequestDto followRequestDto){
        followService.add(followRequestDto);
        return new ResponseEntity<>("Followed", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody FollowRequestDto  followRequestDto){
        followService.delete(followRequestDto);
        return new ResponseEntity<>("Unfollowed",HttpStatus.OK);
    }
}
