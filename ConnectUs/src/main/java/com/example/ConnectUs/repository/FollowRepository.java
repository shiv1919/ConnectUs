package com.example.ConnectUs.repository;

import com.example.ConnectUs.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
    Optional<Follow> findByUser_IdAndFollowing_Id(int userId, int followingId);
    List<Follow> findAllByUser_Id(int userId);
}
