package com.coupang.clone.Service;

import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.controller.dto.ProductSimpleResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ProductResponseDto register(ProductRegisterRequestDto productRegisterRequestDto);
    List<ProductResponseDto> findDetailAll();
    List<ProductSimpleResponseDto> findAllProductIdAndName();
    ProductResponseDto findById(Long productId);
    void delete(Long productId);
    List<ProductResponseDto> findByName(String name);
    void updateFile(Long productId, MultipartFile file);
}
