package com.coupang.clone.repository;

import com.coupang.clone.Repository.CategoryRepository;
import com.coupang.clone.Repository.MemberRepository;
import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository ProductRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void save() {
        Product product = new Product();

        product.setProductName("p3");
        product.setPrice(150);
        product.setStock(200);
        product.setRegisterDate(new Date());
        product.setProductInfo("p3설명");
        product.setMember(memberRepository.findById(3L).get());
        product.setCategory(categoryRepository.findById(3L).get());

        ProductRepository.save(product);
    }

    @Test
    @Transactional
    void findAll() {
        List<Product> productList = ProductRepository.findAll();
        for (Product product : productList) {
            System.out.println("product = " + product);
        }
    }

    @Test
    void findByProductId() {
        Optional<Product> product = ProductRepository.findById(1L);
        assertThat(product.get().getId()).isEqualTo(1L);
    }

    @Test
    @Transactional
    void deleteById() {
        ProductRepository.deleteById(2L);
    }

}