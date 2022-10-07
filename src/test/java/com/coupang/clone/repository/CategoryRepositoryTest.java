package com.coupang.clone.repository;

import com.coupang.clone.Repository.CategoryRepository;
import com.coupang.clone.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void 카테고리_등록(){
        Category category = Category.builder()
                .description("의약품")
                .build();

        Long id = categoryRepository.save(category).getId();
        System.out.println("id = " + id);
    }

    @Test
    void 카테고리_설명조회(){
        Optional<Category> optionalCategory = categoryRepository.findByDescription("식품");
        Category category;
        if(optionalCategory.isPresent()){
            category = optionalCategory.get();
            Assertions.assertThat(category.getId()).isEqualTo(1L);
        }
    }

    @Test
    void 카테고리_ID조회(){
        Optional<Category> optionalCategory = categoryRepository.findById(1L);
        Category category;
        if(optionalCategory.isPresent()){
            category = optionalCategory.get();
            Assertions.assertThat(category.getId()).isEqualTo(1L);
        }
    }

    @Test
    void 카테고리_전체조회(){
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            System.out.println("category = " + category);
        }
    }

    @Test
    void 카테고리_삭제() {
        categoryRepository.deleteById(1L);
    }

}