package com.example.ConnectUs.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowingResponseDto {
    private int userId;
    private String firstname;
    private String lastName;
}
