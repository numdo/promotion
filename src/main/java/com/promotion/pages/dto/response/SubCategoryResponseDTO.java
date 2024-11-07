package com.promotion.pages.dto.response;
// src/main/java/com/promotion/dto/response/SubCategoryResponseDTO.java

import com.promotion.pages.model.SubCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubCategoryResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Long mainCategoryId;

    public SubCategoryResponseDTO(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.name = subCategory.getName();
        this.description = subCategory.getDescription();
        if (subCategory.getMainCategory() != null) {
            this.mainCategoryId = subCategory.getMainCategory().getId();
        }
    }
}
