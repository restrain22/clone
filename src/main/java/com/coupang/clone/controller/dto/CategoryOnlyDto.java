package com.coupang.clone.controller.dto;

import com.coupang.clone.domain.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryOnlyDto {
    private Long id;
    private String description;

    public CategoryOnlyDto(Category category) {
        this.id = category.getId();
        this.description = category.getDescription();
    }

    public CategoryOnlyDto toDto(Category category) {
        return new CategoryOnlyDto(category);
    }
}
