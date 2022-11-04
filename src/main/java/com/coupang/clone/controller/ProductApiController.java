package com.coupang.clone.controller;

import com.coupang.clone.Service.ProductService;
import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.controller.dto.ProductSimpleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    /**
     * 전체 정보 가져오기
     */
    @GetMapping("/product/detailAll")
    public List<ProductResponseDto> getProductDetailList() {
        return productService.findDetailAll();
    }

    /**
     * 간편 정보 가져오기
     */
    @GetMapping("/product/simpleAll")
    public List<ProductSimpleResponseDto> getProductSimpleList() {
        return productService.findAllProductIdAndName();
    }

    /**
     * 한 건 정보 가져오기
     */
    @GetMapping("/product/id/{id}")
    public ProductResponseDto getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    /**
     * 상품 등록하기
     */
    @PostMapping("/product/register")
    public ProductResponseDto saveProduct(ProductRegisterRequestDto productRegisterRequestDto) {
        return productService.register(productRegisterRequestDto);
    }

    /**
     * 상품 image 정보 수정
     */
    @PostMapping("/product/modify_image")
    public @ResponseBody void image(Long productId, MultipartFile file){
        productService.updateFile(productId,file);
    }


    /**
     * 포함 단어 검색 search like %
     */
    @GetMapping("/product/find/{name}")
    public List<ProductResponseDto> searchForName(@PathVariable String name){
        return productService.findByName(name);
    }


    /**
     * 상품 삭제
     */
    @GetMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.delete(id);
    }
}
