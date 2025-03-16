package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.request.PostAddRequestDto;
import com.example.ConnectUs.dto.response.post.PostResponseDto;
import com.example.ConnectUs.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "user.lastName",target = "userLastName")
    @Mapping(source = "user.firstname",target = "userName")
    PostResponseDto postToPostResponseDto(Post post);

    List<PostResponseDto> postsToPostResponseDto(List<Post> posts);

    @Mapping(source = "userId",target = "user.id")
    Post postAddRequestDtoToPost(PostAddRequestDto postAddRequestDto);
}
