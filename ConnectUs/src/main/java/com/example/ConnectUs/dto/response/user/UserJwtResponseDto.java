package com.example.ConnectUs.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJwtResponseDto {
    private int id;
    private String fullName;
    private String email;
}
