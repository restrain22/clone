package com.coupang.clone.Repository;

import com.coupang.clone.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);
    Optional<Category> findById(Long id);
    Optional<Category> findByDescription(String description);
    List<Category> findAll();
    void deleteById(Long id);
}
