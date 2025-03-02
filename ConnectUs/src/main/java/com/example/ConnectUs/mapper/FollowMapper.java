package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.request.FollowRequestDto;
import com.example.ConnectUs.entity.Follow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FollowMapper {
    @Mapping(source = "userId",target = "user.id")
    @Mapping(source = "followingId",target = "following.id")
    Follow followRequestDtoToFollow(FollowRequestDto followRequestDto);
}

