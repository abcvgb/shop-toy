package com.example.chkimshop.order.enums;

public enum OrderEnum {
    ORDERED("ORDERED", "ORDERED"),
    SHIPPING("SHIPPING", "SHIPPING"),
    SHIPPED("SHIPPED", "SHIPPED");

    private String key;
    private String value;


    OrderEnum(String key, String value) {
        this.key = key;
        this.value = value;

    }
}
