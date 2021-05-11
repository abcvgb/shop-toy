package com.example.chkimshop.catalog.controller;

import com.example.chkimshop.catalog.dto.ResponseItem;
import com.example.chkimshop.catalog.repository.ItemRepository;
import com.example.chkimshop.item.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ItemRepository itemRepository;

    @GetMapping("/api/category/{id}/items")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<ResponseItem> getAllItemListByCategoryId(@PathVariable Long id) {
        List<Item> allByCategoryId = itemRepository.findAllByCategoryId(id);
        ArrayList<ResponseItem> arrayList = new ArrayList();
        for (com.example.chkimshop.item.entity.Item item : allByCategoryId) {
            arrayList.add(new ResponseItem(item));
        }
        return arrayList;
    }
}
