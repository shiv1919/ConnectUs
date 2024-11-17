package com.example.ConnectUs.mappers;

import com.example.ConnectUs.models.Follow;
import com.example.ConnectUs.requests.UserAddRequest;
import com.example.ConnectUs.responses.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.ConnectUs.models.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "user.name",target = "name")
    @Mapping(source = "user.lastName",target = "lastName")
    com.example.ConnectUs.responses.user.UserFollowerResponse followToFollowerResponse(Follow follow);
    @Mapping(source = "following.id",target = "userId")
    @Mapping(source = "following.lastName",target = "lastName")
    @Mapping(source = "following.name",target = "name")
    com.example.ConnectUs.responses.user.UserFollowingResponse followToFollowingResponse(Follow follow);
    @Mapping(source = "followers",target = "followers")
    @Mapping(source = "following",target = "following")
    com.example.ConnectUs.responses.user.UserResponse userToResponse(User user);

    User requestToUser(UserAddRequest userAddRequest);

    List<com.example.ConnectUs.responses.user.UserResponse> usersToResponses(List<User> users);

    List<com.example.ConnectUs.responses.user.UserFollowingResponse> followsToFollowingResponses(List<Follow> follows);
}
