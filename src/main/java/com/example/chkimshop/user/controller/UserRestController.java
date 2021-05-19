package com.example.chkimshop.user.controller;

import com.example.chkimshop.user.dto.RequestCreateUser;
import com.example.chkimshop.user.dto.ResponseUser;
import com.example.chkimshop.user.entity.User;
import com.example.chkimshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseUser getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("/api/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Validated RequestCreateUser requestCreateUser) {
        userService.createUser(requestCreateUser);
    }
}
