package com.example.ConnectUs.repository;

import com.example.ConnectUs.entity.UserProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserImageRepository extends JpaRepository<UserProfileImage, Integer> {
    Optional<UserProfileImage> findByUser_Id(int userId);
}
