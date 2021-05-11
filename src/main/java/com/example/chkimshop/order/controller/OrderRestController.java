package com.example.chkimshop.order.controller;

import com.example.chkimshop.common.exception.UserEntityNotFoundException;
import com.example.chkimshop.order.dto.RequestCreateOrder;
import com.example.chkimshop.order.service.OrderService;
import com.example.chkimshop.user.entity.User;
import com.example.chkimshop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;
    private final UserRepository userRepository;


    @PostMapping("/api/users/{userId}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@PathVariable Long userId, @RequestBody List<RequestCreateOrder> order) {
        User buyUser = userRepository.findById(userId).orElseThrow(UserEntityNotFoundException::new);
        orderService.createOrder(buyUser, order);
    }


}
