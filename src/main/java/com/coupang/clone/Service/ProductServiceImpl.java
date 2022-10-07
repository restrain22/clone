package com.coupang.clone.Service;

import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product register(ProductRegisterRequestDto productRegisterRequestDto){
        Product product = productRegisterRequestDto.toEntity();
         productRepository.save(product);
        return product;
    }

    @Override
    public List<ProductResponseDto> findAll(){
        List<ProductResponseDto> productList = productRepository.findAll().stream().map(product -> new ProductResponseDto(product))
                .collect(Collectors.toList());
        return productList;
    }

    @Override
    public ProductResponseDto findOne(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductResponseDto(product);
    }

    @Override
    public void delete(Long id){
        productRepository.deleteById(id);
    }

}
