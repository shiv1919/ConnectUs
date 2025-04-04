package com.example.ConnectUs.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddRequestDto {
    private String firstname;
    private String lastName;
    private String useremail;
    private String password;
}
