package com.example.chkimshop.item.entity;

import com.example.chkimshop.catalog.entity.Category;
import com.example.chkimshop.common.exception.StockQuantityNotEnoughtException;
import com.example.chkimshop.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Getter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private String price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private User seller;


    public void decreaseStockQuantity(Long quantity) {
        if (this.getStockQuantity() >= quantity) {
            this.stockQuantity -= quantity;
            return;
        }
        throw new StockQuantityNotEnoughtException();
    }


}
