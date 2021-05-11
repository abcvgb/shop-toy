package com.example.chkimshop.order.service;

import com.example.chkimshop.catalog.repository.ItemRepository;
import com.example.chkimshop.catalog.service.ItemService;
import com.example.chkimshop.common.exception.ItemEntityNotFoundException;
import com.example.chkimshop.item.entity.Item;
import com.example.chkimshop.order.dto.RequestCreateOrder;
import com.example.chkimshop.order.entity.Order;
import com.example.chkimshop.order.repository.OrderRepository;
import com.example.chkimshop.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;


    public void createOrder(User buyUser, List<RequestCreateOrder> orderList) {
        ArrayList<Item> list = new ArrayList<>();

        for (RequestCreateOrder order : orderList) {
            Item item = itemRepository.findById(order.getItemId()).orElseThrow(ItemEntityNotFoundException::new);
            list.add(item);
            itemService.decreaseStockQuantity(item, order.getQuantity());
        }

        Order order = Order.builder()
                .buyUser(buyUser)
                .itemList(list)
                .build();

        orderRepository.save(order);
    }
}
