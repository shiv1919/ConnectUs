package com.example.ConnectUs.dto.response.postImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostImageResponseDto {
    private int id;
    private String imagename;
    private String imagetype;
    private int postId;
}
