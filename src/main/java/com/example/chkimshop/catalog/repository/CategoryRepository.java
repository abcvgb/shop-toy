package com.example.chkimshop.catalog.repository;

import com.example.chkimshop.catalog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
