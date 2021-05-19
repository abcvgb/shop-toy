package com.example.chkimshop.order.dto;

import com.example.chkimshop.order.enums.OrderEnum;
import com.example.chkimshop.user.dto.ResponseUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrder {

    private Long id;

    private ResponseUser user;

    private OrderEnum orderStatus;

//    private List<com.example.chkimshop.item.entity.Item> itemList;

}
