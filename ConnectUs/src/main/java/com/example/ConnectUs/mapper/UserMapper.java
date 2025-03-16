package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.request.UserAddRequestDto;
import com.example.ConnectUs.dto.response.user.UserFollowingResponseDto;
import com.example.ConnectUs.dto.response.user.UserResponseDto;
import com.example.ConnectUs.entity.Follow;
import com.example.ConnectUs.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto userToUserResponseDto(User user);
    User userAddRequestDtoToUser(UserAddRequestDto userAddRequestDto);
    List<UserFollowingResponseDto> followsToUserFollowingResponseDto(List<Follow> follows);

    @Mapping(source = "following.id", target = "userId")
    UserFollowingResponseDto followToUserFollowingResponseDto(Follow follow);
}
