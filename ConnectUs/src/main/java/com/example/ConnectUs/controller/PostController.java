package com.example.ConnectUs.controller;

import com.example.ConnectUs.dto.response.post.PostResponseDto;
import com.example.ConnectUs.dto.response.postImage.PostImageResponseDto;
import com.example.ConnectUs.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/connectus/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<PostResponseDto>> getAll(){
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PostResponseDto> getById(@PathVariable int id){
        return new ResponseEntity<>(postService.getResponseById(id),HttpStatus.OK);
    }

    @GetMapping("/getallbyuser/{userId}")
    public ResponseEntity<List<PostResponseDto>> getAllByUser(@PathVariable int userId){
        return new ResponseEntity<>(postService.getAllByUser(userId),HttpStatus.OK);
    }

    @GetMapping("/getbyuserfollowing/{userId}")
    public ResponseEntity<List<PostResponseDto>> getAllByUserFollowing(@PathVariable int userId){
        return new ResponseEntity<>(postService.getByUserFollowing(userId),HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PostImageResponseDto> add(@RequestPart("image") MultipartFile file, @RequestPart("postAddRequestDto") String postAddRequestDtoJson) throws IOException {
        PostImageResponseDto postImageResponseDto = postService.add(file, postAddRequestDtoJson);
        return new ResponseEntity<>(postImageResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        postService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @GetMapping("/fetch/{postId}")
    public ResponseEntity<?> download(@PathVariable int postId){
        byte[] post = postService.fetch(postId);
        if (post!=null){
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(post);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
