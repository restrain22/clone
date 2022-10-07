package com.coupang.clone.controller;

import com.coupang.clone.Service.ProductService;
import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/product/all")
    public List<ProductResponseDto> getProductList() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) {
        return productService.findOne(id);
    }

    @PostMapping("/product/register")
    public Product saveProduct(@RequestBody ProductRegisterRequestDto productRegisterRequestDto) {
        return productService.register(productRegisterRequestDto);
    }

    @GetMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
