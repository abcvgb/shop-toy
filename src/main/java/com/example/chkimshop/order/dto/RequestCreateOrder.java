package com.example.chkimshop.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateOrder {

    @NotNull
    private Long itemId;
    @NotNull
    private Long quantity;

}
