package com.example.chkimshop.catalog.dto;

import com.example.chkimshop.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseItem {
    private Long id;
    private String itemName;
    private String price;
    private int stockQuantity;
    private String categoryName;


    public ResponseItem(Item item) {
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.price = item.getPrice();
        this.stockQuantity = item.getStockQuantity();
        this.categoryName = item.getCategory().getCategoryName();
    }
}
