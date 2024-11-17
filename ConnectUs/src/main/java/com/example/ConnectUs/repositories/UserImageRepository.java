package com.example.ConnectUs.repositories;

import com.example.ConnectUs.models.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserImageRepository extends JpaRepository<UserImage, Integer> {
    Optional<UserImage> findByUser_Id(int userId);
}
