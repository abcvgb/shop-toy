package com.example.chkimshop.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateUser {

    @Size(min = 2, message = "name 2 more")
    private String username;
    @Size(min = 4, message = "password 4 more")
    private String password;
}
