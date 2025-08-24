package com.example.ConnectUs.mapper;

import com.example.ConnectUs.dto.request.CommentAddRequest;
import com.example.ConnectUs.dto.response.Comment.CommentResponse;
import com.example.ConnectUs.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "user.id",target = "userId")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "user.firstname",target = "firstname")
    @Mapping(source = "user.lastName",target = "lastName")
    CommentResponse commentToResponse(Comment comment);
    List<CommentResponse> commentsToResponses(List<Comment> comments);
    @Mapping(source = "userId",target = "user.id")
    @Mapping(source = "postId",target = "post.id")
    Comment addRequestToComment(CommentAddRequest commentAddRequest);
}
