package com.example.chkimshop.user.service;

import com.example.chkimshop.common.exception.UserEntityNotFoundException;
import com.example.chkimshop.user.dto.RequestCreateUser;
import com.example.chkimshop.user.dto.ResponseUser;
import com.example.chkimshop.user.entity.User;
import com.example.chkimshop.user.repository.UserRepository;
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

    @Transactional(readOnly = true)
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(UserEntityNotFoundException::new);
    }

    public ResponseUser getById(Long id) {
        return userRepository.getById(id);
    }
}
