package com.example.ConnectUs.service;

import com.example.ConnectUs.dto.request.LikeRequestDto;
import com.example.ConnectUs.dto.response.Like.LikeResponseDto;
import com.example.ConnectUs.entity.Like;
import com.example.ConnectUs.mapper.LikeMapper;
import com.example.ConnectUs.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final LikeMapper likeMapper;

    public LikeService(LikeRepository likeRepository, LikeMapper likeMapper) {
        this.likeRepository = likeRepository;
        this.likeMapper = likeMapper;
    }

    public void add(LikeRequestDto likeRequestDto){
        if (isLiked(likeRequestDto)){
            return;
        }
        Like like = likeMapper.likeRequestDtoToLike(likeRequestDto);
        likeRepository.save(like);
    }

    public List<LikeResponseDto> getAllByPost(int postId){
        List<Like> likes = likeRepository.findAllByPost_Id(postId);
        return likeMapper.likeToLikeResponseDto(likes);
    }

    public List<LikeResponseDto> getAllByUser(int userId){
        List<Like> likes = likeRepository.findAllByUser_Id(userId);
        return likeMapper.likeToLikeResponseDto(likes);
    }

    public boolean isLiked(LikeRequestDto likeRequestDto){
        Optional<Like> like = likeRepository.findByUser_IdAndPost_Id(likeRequestDto.getUserId(),likeRequestDto.getPostId());
        return like.isPresent();
    }



    public void delete(LikeRequestDto likeRequestDto){
        Optional<Like> like = likeRepository.findByUser_IdAndPost_Id(likeRequestDto.getUserId(),likeRequestDto.getPostId());
        likeRepository.delete(like.get());
    }
}
