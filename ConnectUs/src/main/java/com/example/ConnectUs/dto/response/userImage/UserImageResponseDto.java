package com.example.ConnectUs.dto.response.userImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserImageResponseDto {
    private int id;
    private String name;
    private String type;
    private byte[] data;
    private int userId;
}
