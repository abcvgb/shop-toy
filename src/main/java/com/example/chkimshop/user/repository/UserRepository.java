package com.example.chkimshop.user.repository;

import com.example.chkimshop.user.dto.ResponseUser;
import com.example.chkimshop.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    ResponseUser getById(Long id);

}
