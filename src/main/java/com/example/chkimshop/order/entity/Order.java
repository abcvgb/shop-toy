package com.example.chkimshop.order.entity;

import com.example.chkimshop.order.enums.OrderEnum;
import com.example.chkimshop.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buy_user_id", nullable = false)
    private User buyUser;

    @Column(name = "order_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OrderEnum orderStatus;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;

    public void addOrderItemList(OrderItem orderItem) {
        if (ObjectUtils.isEmpty(orderItemList)) orderItemList = new ArrayList<>();
        this.orderItemList.add(orderItem);
    }
}
