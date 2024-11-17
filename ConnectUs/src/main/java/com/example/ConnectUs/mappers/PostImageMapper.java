package com.example.ConnectUs.mappers;

import com.example.ConnectUs.models.PostImage;
import com.example.ConnectUs.responses.postImage.PostImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostImageMapper {

    @Mapping(source = "post.id",target = "postId")
    PostImageResponse imageToResponse(PostImage postImage);

}
