package com.coupang.clone.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void updateCategory() {
        categoryService.updateCategory("의류","자동차");
    }

    @Test
    void addCategory() {
        categoryService.addCategory("전자장비");
    }

    @Test
    void deleteCategory() {
        categoryService.deleteCategory("의류");
    }

    @Test
    void findCategoryByDescription() {
        assertThat(categoryService.findCategoryByDescription("스포츠").getId()).isEqualTo(2L);
    }

    @Test
    void findCategoryById() {
        assertThat(categoryService.findCategoryById(2L).getDescription()).isEqualTo("스포츠");

        assertThrows(IllegalStateException.class, () -> {
            categoryService.findCategoryById(1L);
        });
    }
}