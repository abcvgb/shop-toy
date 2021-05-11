package com.example.chkimshop.catalog.service;

import com.example.chkimshop.catalog.repository.ItemRepository;
import com.example.chkimshop.common.exception.StockQuantityNotEnoughtException;
import com.example.chkimshop.item.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void decreaseStockQuantity(Item item, Long quantity) {
        item.decreaseStockQuantity(quantity);
        itemRepository.save(item);
    }
}
