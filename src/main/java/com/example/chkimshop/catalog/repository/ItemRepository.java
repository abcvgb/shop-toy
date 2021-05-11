package com.example.chkimshop.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<com.example.chkimshop.item.entity.Item, Long> {
    List<com.example.chkimshop.item.entity.Item> findAllByCategoryId(Long id);
}
