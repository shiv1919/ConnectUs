package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.request.UserAddRequestDto;
import com.example.ConnectUs.dto.response.user.UserResponseDto;
import com.example.ConnectUs.entity.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto userToUserResponseDto(User user);
    User userAddRequestDtoToUser(UserAddRequestDto userAddRequestDto);
}
