package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.domain.Product;

import java.util.List;

public interface ProductService {
    Product register(ProductRegisterRequestDto productRegisterRequestDto);
    List<ProductResponseDto> findAll();
    ProductResponseDto findOne(Long productId);
    void delete(Long productId);
}
