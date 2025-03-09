package com.example.ConnectUs.service;

import com.example.ConnectUs.dto.response.userImage.UserImageResponseDto;
import com.example.ConnectUs.entity.UserProfileImage;
import com.example.ConnectUs.mapper.UserImageMapper;
import com.example.ConnectUs.repository.UserImageRepository;
import com.example.ConnectUs.util.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserImageService {
    private final UserImageRepository userImageRepository;
    private final UserService userService;
    private final UserImageMapper userImageMapper;

    public UserImageService(UserImageRepository userImageRepository, UserService userService, UserImageMapper userImageMapper) {
        this.userImageRepository = userImageRepository;
        this.userService = userService;
        this.userImageMapper = userImageMapper;
    }

    public UserImageResponseDto uploadImage(MultipartFile multipartFile, int userId) throws IOException {
        UserProfileImage userProfileImage = new UserProfileImage();
        userProfileImage.setImagedata(ImageUtil.compressImage(multipartFile.getBytes()));
        userProfileImage.setImagename(multipartFile.getOriginalFilename());
        userProfileImage.setImagetype(multipartFile.getContentType());
        userProfileImage.setUser(userService.findById(userId));
        userImageRepository.save(userProfileImage);
        return userImageMapper.userProfileImageToUserImageResponseDto(userProfileImage);
    }

    public byte[] fetchImage(int id){
        Optional<UserProfileImage> userImage = userImageRepository.findByUser_Id(id);
        return ImageUtil.decompressImage(userImage.get().getImagedata());
    }
}
