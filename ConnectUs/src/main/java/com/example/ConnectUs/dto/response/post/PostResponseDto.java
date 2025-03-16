package com.example.ConnectUs.dto.response.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private int id;
    private int userId;
    private String userName;
    private String userLastName;
    private String caption;
}
