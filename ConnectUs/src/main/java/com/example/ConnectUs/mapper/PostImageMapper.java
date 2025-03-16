package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.response.postImage.PostImageResponseDto;
import com.example.ConnectUs.entity.PostImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostImageMapper {
    @Mapping(source = "post.id",target = "postId")
    PostImageResponseDto postImageToPostImageResponseDto(PostImage postImage);
}
