package com.example.ConnectUs.mappers;

import com.example.ConnectUs.models.UserImage;
import com.example.ConnectUs.responses.userImage.UserImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserImageMapper {

    @Mapping(source = "user.id",target = "userId")
    UserImageResponse userImageToResponse(UserImage userImage);

}
