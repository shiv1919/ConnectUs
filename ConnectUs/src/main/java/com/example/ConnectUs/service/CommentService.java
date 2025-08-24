package com.example.ConnectUs.service;

import com.example.ConnectUs.dto.request.CommentAddRequest;
import com.example.ConnectUs.dto.request.CommentUpdateRequest;
import com.example.ConnectUs.dto.response.Comment.CommentResponse;
import com.example.ConnectUs.entity.Comment;
import com.example.ConnectUs.mapper.CommentMapper;
import com.example.ConnectUs.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public void add(CommentAddRequest commentAddRequest){
        Comment comment = commentMapper.addRequestToComment(commentAddRequest);
        commentRepository.save(comment);
    }

    public List<CommentResponse> getAllComments(){
        List<Comment> comments = commentRepository.findAll();
        return commentMapper.commentsToResponses(comments);
    }

    public CommentResponse getById(int id){
        Comment comment = commentRepository.findById(id).orElse(null);
        return  commentMapper.commentToResponse(comment);
    }

    public List<CommentResponse> getAllCommentsByPost(int postId){
        List<Comment> comments = commentRepository.findAllByPost_Id(postId);
        return commentMapper.commentsToResponses(comments);
    }

    public List<CommentResponse> getAllCommentsByUser(int userId){
        List<Comment> comments = commentRepository.findAllByUser_Id(userId);
        return commentMapper.commentsToResponses(comments);
    }
    public void update(int id, CommentUpdateRequest commentUpdateRequest){
        Comment commentToUpdate = commentRepository.findById(id).orElse(null);
        if (commentToUpdate!=null){
            commentToUpdate.setComment(commentUpdateRequest.getComment());
        }
    }

    public void remove(int id){
        commentRepository.deleteById(id);
    }
}