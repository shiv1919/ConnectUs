package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.request.LikeRequestDto;
import com.example.ConnectUs.dto.response.Like.LikeResponseDto;
import com.example.ConnectUs.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    @Mapping(source = "postId",target = "post.id")
    @Mapping(source = "userId",target = "user.id")
    Like likeRequestDtoToLike(LikeRequestDto likeRequestDto);
    List<LikeResponseDto> likeToLikeResponseDto(List<Like> likes);
    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "user.firstname",target = "firstname")
    @Mapping(source = "user.lastName",target = "lastName")
    LikeResponseDto likeToLikeResponseDto(Like like);
}
