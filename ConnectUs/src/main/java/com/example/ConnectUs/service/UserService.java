package com.example.ConnectUs.service;

import com.example.ConnectUs.dto.request.UserAddRequestDto;
import com.example.ConnectUs.dto.response.user.UserFollowingResponseDto;
import com.example.ConnectUs.dto.response.user.UserResponseDto;
import com.example.ConnectUs.entity.Follow;
import com.example.ConnectUs.entity.User;
import com.example.ConnectUs.mapper.UserMapper;
import com.example.ConnectUs.repository.FollowRepository;
import com.example.ConnectUs.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository, FollowRepository followRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.followRepository = followRepository;
    }

    public List<UserResponseDto> getAll(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToUserResponseDto)
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDto> getById(int id){
        return userRepository.findById(id)
                .map(userMapper::userToUserResponseDto);
    }

    public boolean isFollowing(int userId,int followingId){
        Optional<Follow> follow = followRepository.findByUser_IdAndFollowing_Id(userId,followingId);
        return follow.isPresent();
    }

    public void add(UserAddRequestDto userAddRequestDto){
        User user = userMapper.userAddRequestDtoToUser(userAddRequestDto);
        userRepository.save(user);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }
    public User findById(int id){
        return userRepository.findById(id).get();
    }

    public List<UserFollowingResponseDto> getUserFollowing(int userId) {
        List<Follow> follows = followRepository.findAllByUser_Id(userId);
        return userMapper.followsToUserFollowingResponseDto(follows);
    }

}
