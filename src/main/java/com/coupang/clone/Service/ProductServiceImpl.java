package com.coupang.clone.Service;

import com.coupang.clone.Config;
import com.coupang.clone.Repository.ProductRepository;
import com.coupang.clone.controller.dto.ProductRegisterRequestDto;
import com.coupang.clone.controller.dto.ProductResponseDto;
import com.coupang.clone.controller.dto.ProductSimpleResponseDto;
import com.coupang.clone.domain.Category;
import com.coupang.clone.domain.Member;
import com.coupang.clone.domain.Product;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final MemberService memberService;
    private final CategoryService categoryService;

    /**
     * 등록
     */
    @Override
    public ProductResponseDto register(ProductRegisterRequestDto productRegisterRequestDto){
        Member member = memberService.findMemberByLoginId(productRegisterRequestDto.getProductOwnerId());
        Category category = categoryService.findCategoryByDescription(productRegisterRequestDto.getCategoryName());

        Product product = productRegisterRequestDto.toEntity();
//        try {
//            ImageEntity imageEntity = saveFile(productRegisterRequestDto.getMultipartFile());
//            product.insertFile(imageEntity.getName(),imageEntity.getPath());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        ImageEntity imageEntity = saveFile(productRegisterRequestDto.getMultipartFile());

        product.insertFile(imageEntity.getName(),imageEntity.getPath());

        product.joinMemberAndCategory(member, category);
        productRepository.save(product);

        return new ProductResponseDto(product);
    }

    /**
     * 전체 정보 가져오기
     */
    @Override
    public List<ProductResponseDto> findDetailAll(){
        List<ProductResponseDto> productList = productRepository.findAll().stream().map(product -> new ProductResponseDto(product))
                .collect(Collectors.toList());
        return productList;
    }

    /**
     * 상품 ID와 상품명만 가져오기
     */
    @Override
    public List<ProductSimpleResponseDto> findAllProductIdAndName(){
        List<ProductSimpleResponseDto> productList = productRepository.findAll().stream().map(product -> new ProductSimpleResponseDto(product))
                .collect(Collectors.toList());
        return productList;
    }

    /**
     * 한 건만 가져오기
     */
    @Override
    public ProductResponseDto findById(Long id) {
        Product product = productRepository.findById(id).orElseGet(
                () -> {
                    throw new IllegalStateException("해당되는 상품이 없습니다.");
                }
        );
        return new ProductResponseDto(product);
    }

    /**
     * 이름으로 가져오기
     */
    @Override
    public List<ProductResponseDto> findByName(String name){
        List<Product> productList = productRepository.findByNameContaining(name);
        return productList.stream().map(product -> new ProductResponseDto().toDto(product)).collect(Collectors.toList());
    }

    /**
     * 한 건 삭제
     */
    @Override
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    /**
     * 파일 변경 및 경로값 불러오기
     */
    private ImageEntity saveFile(MultipartFile file){

        ImageEntity imageEntity;
        Path imagePath = getFilePath(file);

        try {
            Files.write(imagePath, file.getBytes());
            imageEntity = ImageEntity.builder()
                    .name(file.getOriginalFilename())
                    .path(imagePath.toString())
                    .build();
        } catch (Exception e) {
            throw new IllegalStateException("파일 업로드 중 에러가 발생했습니다.");
        }
        return imageEntity;
    }


    /**
     * 파일 업데이트
     */
    @Transactional
    public void updateFile(Long productId,MultipartFile file) {
        ImageEntity imageEntity = saveFile(file);
        productRepository.findById(productId).orElseGet(() ->
        {
            throw new IllegalStateException("파일 업로드 중 에러가 발생했습니다.");
        }).updateFile(imageEntity.getName(),imageEntity.getPath());
//        productRepository.findById(productId).ifPresent(product -> {
//            try {
//                ImageEntity imageEntity = saveFile(file);
//                product.updateFile(imageEntity.getName(),imageEntity.getPath());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
    }

    /**
     * 파일 경로 가져오기
     */
    private Path getFilePath(MultipartFile file ){
        UUID uuid = UUID.randomUUID();
        //파일 이름 찾는 함수
        String name= uuid + "_" + file.getName();


        String[] split = file.getOriginalFilename().split("\\.");
        String extension = split[split.length - 1];

        Path imagePath = Paths.get(Config.FilePath + name + "." + extension);
        return imagePath;
    }

    @NoArgsConstructor
    @Getter
    static class ImageEntity{
        String name;
        String path;

        @Builder
        public ImageEntity(String name, String path) {
            this.name = name;
            this.path = path;
        }
    }
}
