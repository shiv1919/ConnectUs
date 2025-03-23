package com.example.ConnectUs.dto.response.Like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeResponseDto {
    private int id;
    private int userId;
    private String firstname;
    private String lastName;
}
