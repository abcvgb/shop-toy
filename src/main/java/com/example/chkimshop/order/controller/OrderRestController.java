package com.example.chkimshop.order.controller;

import com.example.chkimshop.order.dto.RequestCreateOrder;
import com.example.chkimshop.order.entity.Order;
import com.example.chkimshop.order.service.OrderService;
import com.example.chkimshop.user.entity.User;
import com.example.chkimshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping("/api/users/{userId}/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getUserOrderListByUserId(@PathVariable Long userId) {
        return orderService.getUserOrderListByUserId(userId);
    }


    @PostMapping("/api/users/{userId}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@PathVariable Long userId, @RequestBody List<RequestCreateOrder> order) {
        User buyUser = userService.findById(userId);
        orderService.createOrder(buyUser, order);
    }

}
