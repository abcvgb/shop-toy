package com.example.chkimshop.user.service;

import com.example.chkimshop.user.entity.User;
import com.example.chkimshop.user.repository.UserRepository;
import com.example.chkimshop.user.dto.RequestCreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(RequestCreateUser requestCreateUser) {
        User user = new User(requestCreateUser);
        userRepository.save(user);
        return user;
    }


}
