package com.coupang.clone.Service;

import com.coupang.clone.domain.Category;

public interface CategoryService {
    String updateCategory(String bfDesc,String afDesc);
    Long addCategory(String desc);
    String deleteCategory(String desc);
    Category findCategoryByDescription(String desc);
    Category findCategoryById(Long id);
}
