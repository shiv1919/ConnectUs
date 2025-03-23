package com.example.ConnectUs.controller;

import com.example.ConnectUs.dto.request.LikeRequestDto;
import com.example.ConnectUs.dto.response.Like.LikeResponseDto;
import com.example.ConnectUs.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connectus/likes")
public class LikesController {

    private final LikeService likeService;

    public LikesController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody LikeRequestDto likeRequestDto){
        likeService.add(likeRequestDto);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    @GetMapping("/getallbypost/{postId}")
    public ResponseEntity<List<LikeResponseDto>> getAllByPost(@PathVariable int postId){
        return new ResponseEntity<>(likeService.getAllByPost(postId),HttpStatus.OK);
    }

    @GetMapping("/getallbyuser/{userId}")
    public ResponseEntity<List<LikeResponseDto>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(likeService.getAllByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/isliked")
    public ResponseEntity<Boolean> isLiked(@RequestBody LikeRequestDto likeRequestDto){
        return new ResponseEntity<>(likeService.isLiked(likeRequestDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody LikeRequestDto likeRequestDto){
        likeService.delete(likeRequestDto);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
