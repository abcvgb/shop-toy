package com.example.chkimshop.order.entity;

import com.example.chkimshop.BaseEntity;
import com.example.chkimshop.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Builder
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buy_user_id")
    private User buyUser;

    @OneToMany
    private List<com.example.chkimshop.item.entity.Item> itemList;


}
