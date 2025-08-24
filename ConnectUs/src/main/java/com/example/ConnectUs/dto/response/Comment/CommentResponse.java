package com.example.ConnectUs.dto.response.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private int id;
    private int postId;
    private int userId;
    private String firstname;
    private String lastName;
    private String comment;
}
