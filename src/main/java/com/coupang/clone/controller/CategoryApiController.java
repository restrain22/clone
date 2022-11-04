package com.coupang.clone.controller;

import com.coupang.clone.Service.CategoryService;
import com.coupang.clone.controller.dto.CategoryOnlyDto;
import com.coupang.clone.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryApiController {

    private final CategoryService categoryService;


    @GetMapping("/update")
    public String updateCategory(@RequestParam String bfDesc, @RequestParam String afDesc) {
        return categoryService.updateCategory(bfDesc, afDesc);
    }

    //getmapping @pathvariable 동작 안함 문제 해결 필요
    @GetMapping("/save/{desc}")
    public Long addCategory(@PathVariable String desc) {
        return categoryService.addCategory(desc);
    }

    @GetMapping("/delete/{desc}")
    public String deleteCategory(@PathVariable String desc) {
        return categoryService.deleteCategory(desc);
    }

    @GetMapping("/desc/{desc}")
    public CategoryOnlyDto findCategoryByDescription(@PathVariable String desc) {
        return new CategoryOnlyDto().toDto(categoryService.findCategoryByDescription(desc));
    }

    @GetMapping("/id/{id}")
    public CategoryOnlyDto findCategoryById(@PathVariable Long id) {
        return new CategoryOnlyDto().toDto(categoryService.findCategoryById(id));
    }
}
