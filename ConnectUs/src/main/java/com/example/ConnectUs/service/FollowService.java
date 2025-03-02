package com.example.ConnectUs.service;

import com.example.ConnectUs.dto.request.FollowRequestDto;
import com.example.ConnectUs.entity.Follow;
import com.example.ConnectUs.mapper.FollowMapper;
import com.example.ConnectUs.repository.FollowRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final FollowMapper followMapper;
    private final UserService userService;

    public FollowService(FollowRepository followRepository, FollowMapper followMapper, UserService userService) {
        this.followRepository = followRepository;
        this.followMapper = followMapper;
        this.userService = userService;
    }

    public void add(FollowRequestDto followRequestDto){
        if (userService.isFollowing(followRequestDto.getUserId(), followRequestDto.getFollowingId())){
            return;
        }
        Follow follow= followMapper.followRequestDtoToFollow(followRequestDto);
        followRepository.save(follow);
    }

    public  void delete(FollowRequestDto followRequestDto){
        Follow follow = followRepository.findByUser_IdAndFollowing_Id(followRequestDto.getUserId(), followRequestDto.getFollowingId()).orElse(null);
        followRepository.delete(follow);
    }
}
