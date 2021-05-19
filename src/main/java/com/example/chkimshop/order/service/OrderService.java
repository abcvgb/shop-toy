package com.example.chkimshop.order.service;

import com.example.chkimshop.catalog.repository.ItemRepository;
import com.example.chkimshop.catalog.service.ItemService;
import com.example.chkimshop.common.exception.ItemEntityNotFoundException;
import com.example.chkimshop.common.exception.UserEntityNotFoundException;
import com.example.chkimshop.item.entity.Item;
import com.example.chkimshop.order.dto.RequestCreateOrder;
import com.example.chkimshop.order.entity.Order;
import com.example.chkimshop.order.entity.OrderItem;
import com.example.chkimshop.order.enums.OrderEnum;
import com.example.chkimshop.order.repository.OrderRepository;
import com.example.chkimshop.user.entity.User;
import com.example.chkimshop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public void createOrder(User buyUser, List<RequestCreateOrder> orderList) {


        Order createOrder = Order.builder()
                .buyUser(buyUser)
                .orderStatus(OrderEnum.ORDERED)
                .build();

        orderRepository.save(createOrder);

        orderList.forEach(order -> {
            Item item = itemRepository.findById(order.getItemId()).orElseThrow(ItemEntityNotFoundException::new);
            OrderItem orderItem = OrderItem.builder()
                    .item(item)
                    .order(createOrder)
                    .quantity(order.getQuantity())
                    .build();
            createOrder.addOrderItemList(orderItem);
            itemService.decreaseStockQuantity(item, order.getQuantity());
        });


        orderRepository.save(createOrder);
    }

    public List<Order> getUserOrderListByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(UserEntityNotFoundException::new).getOrderList();
    }
}
