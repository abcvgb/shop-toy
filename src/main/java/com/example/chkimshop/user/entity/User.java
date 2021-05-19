package com.example.chkimshop.user.entity;

import com.example.chkimshop.order.entity.Order;
import com.example.chkimshop.user.dto.RequestCreateUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "buyUser", fetch = FetchType.LAZY)
    private List<Order> orderList;


    public User(RequestCreateUser user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }


}
