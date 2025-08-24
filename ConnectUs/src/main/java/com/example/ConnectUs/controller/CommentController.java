package com.example.ConnectUs.controller;

import com.example.ConnectUs.dto.request.CommentAddRequest;
import com.example.ConnectUs.dto.response.Comment.CommentResponse;
import com.example.ConnectUs.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connectus/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CommentResponse>> getAllComments(){
        return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
    }

    @GetMapping("/getallbypost/{postId}")
    public ResponseEntity<List<CommentResponse>> getAllCommentsByPost(@PathVariable int postId){
        return new ResponseEntity<>(commentService.getAllCommentsByPost(postId),HttpStatus.OK);
    }

    @GetMapping("/getallbyuser/{userId}")
    public ResponseEntity<List<CommentResponse>> getAllCommentsByUser(@PathVariable int userId){
        return new ResponseEntity<>(commentService.getAllCommentsByUser(userId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addComment(@RequestBody CommentAddRequest commentRequest){
        commentService.add(commentRequest);
        return new ResponseEntity<>("Added",HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> remove(@RequestParam int id){
        commentService.remove(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
