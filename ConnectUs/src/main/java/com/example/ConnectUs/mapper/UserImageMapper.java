package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.response.userImage.UserImageResponseDto;
import com.example.ConnectUs.entity.UserProfileImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserImageMapper {
    @Mapping(source = "user.id",target = "userId")
    UserImageResponseDto userProfileImageToUserImageResponseDto(UserProfileImage userProfileImage);
}
