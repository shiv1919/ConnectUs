package com.example.ConnectUs.service;

import com.example.ConnectUs.dto.request.PostAddRequestDto;
import com.example.ConnectUs.dto.response.post.PostResponseDto;
import com.example.ConnectUs.dto.response.postImage.PostImageResponseDto;
import com.example.ConnectUs.dto.response.user.UserFollowingResponseDto;
import com.example.ConnectUs.entity.Post;
import com.example.ConnectUs.entity.PostImage;
import com.example.ConnectUs.mapper.PostImageMapper;
import com.example.ConnectUs.mapper.PostMapper;
import com.example.ConnectUs.repository.PostImageRepository;
import com.example.ConnectUs.repository.PostRepository;
import com.example.ConnectUs.util.ImageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserService userService;
    private final PostImageRepository postImageRepository;
    private final PostImageMapper postImageMapper;


    public PostService(PostRepository postRepository, PostMapper postMapper, UserService userService, PostImageRepository postImageRepository, PostImageMapper postImageMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userService = userService;
        this.postImageRepository = postImageRepository;
        this.postImageMapper = postImageMapper;
    }

    public List<PostResponseDto> getAll(){
        List<Post> posts = postRepository.findAll();
        return  postMapper.postsToPostResponseDto(posts);
    }

    public PostResponseDto getResponseById(int id){
        Post post = postRepository.findById(id).orElse(null);
        return postMapper.postToPostResponseDto(post);
    }

    public List<PostResponseDto> getAllByUser(int userId){
        List<Post> userPosts = postRepository.findAllByUser_IdOrderByIdDesc(userId);
        return postMapper.postsToPostResponseDto(userPosts);
    }

    public List<PostResponseDto> getByUserFollowing(int userId) {
        List<UserFollowingResponseDto> follows = userService.getUserFollowing(userId);

        List<Post> posts = new ArrayList<>();

        for (UserFollowingResponseDto user : follows) {
            List<Post> userPosts = postRepository.findAllByUser_IdOrderByIdDesc(user.getUserId());
            posts.addAll(userPosts);
        }

        return postMapper.postsToPostResponseDto(posts);
    }

    public PostImageResponseDto add(MultipartFile file,String postAddRequestDtoJson) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        PostAddRequestDto postAddRequestDto = objectMapper.readValue(postAddRequestDtoJson, PostAddRequestDto.class);

        Post post=postMapper.postAddRequestDtoToPost(postAddRequestDto);
        postRepository.save(post);

        PostImage postImage = new PostImage();
        postImage.setImagename(file.getOriginalFilename());
        postImage.setImagetype(file.getContentType());
        postImage.setPost(postRepository.findById(post.getId()).orElse(null));
        postImage.setImagedata(ImageUtil.compressImage(file.getBytes()));
        postImageRepository.save(postImage);
        return postImageMapper.postImageToPostImageResponseDto(postImage);
    }


    public void delete(int id){
        postRepository.deleteById(id);
    }

    public byte[] fetch(int id){
        Optional<PostImage> postImage = postImageRepository.findPostImageByPost_Id(id);
        if (postImage.isPresent()){
            return ImageUtil.decompressImage(postImage.get().getImagedata());
        }
        return null;
    }
}
