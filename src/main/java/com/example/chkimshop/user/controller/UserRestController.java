package com.example.chkimshop.user.controller;

import com.example.chkimshop.user.dto.RequestCreateUser;
import com.example.chkimshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @PostMapping("/api/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Validated RequestCreateUser requestCreateUser) {
        userService.createUser(requestCreateUser);
    }
}
