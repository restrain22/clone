package com.coupang.clone.Service;

import com.coupang.clone.Repository.CategoryRepository;
import com.coupang.clone.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public String updateCategory(String bfDesc,String afDesc) {
        categoryRepository.findByDescription(bfDesc).ifPresentOrElse(
                category -> {
                    duplicateCategoryValidation(afDesc);
                    category.setDescription(afDesc);
                    categoryRepository.save(category);
                    },
                () -> {
                    throw new IllegalStateException("바꿀 카테코리가 없습니다.");
                }
        );


        categoryRepository.findByDescription(afDesc).ifPresent(
                category -> {
                    category.setDescription(afDesc);
                    categoryRepository.save(category);
                }
        );
        return "Success";
    }

    @Override
    public Long addCategory(String desc) {
        duplicateCategoryValidation(desc);
        Category category = Category.builder()
                .description(desc)
                .build();
        return categoryRepository.save(category).getId();
    }

    @Override
    public String deleteCategory(String desc) {
        categoryRepository.findByDescription(desc).ifPresentOrElse(
                category -> {
                    categoryRepository.deleteById(category.getId());
                }
                , ()->{
                    throw new IllegalStateException("삭제할 카테코리가 없습니다.");
                }
        );
        return "Success";
    }

    @Override
    public Category findCategoryByDescription(String desc) {
        return categoryRepository.findByDescription(desc).orElseGet(() ->
        {
            throw new IllegalStateException("해당되는 카테코리가 없습니다.");
        });
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseGet(() ->
        {
            throw new IllegalStateException("해당되는 카테코리가 없습니다.");
        });
    }

    void duplicateCategoryValidation(String desc) {
        categoryRepository.findByDescription(desc).ifPresent(
            category -> {
                throw new IllegalStateException("이미 존재하는 카테고리입니다.");
            }
        );
    }
}
