package com.promotion.pages.dto.response;

import com.promotion.pages.model.Page;

// src/main/java/com/promotion/dto/response/PageResponseDTO.java

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PageResponseDTO {
    private Long id;
    private String title;
    private String content;
    private Long subCategoryId;

    public PageResponseDTO(Page page) {
        this.id = page.getId();
        this.title = page.getTitle();
        this.content = page.getContent();
        if (page.getSubCategory() != null) {
            this.subCategoryId = page.getSubCategory().getId();
        }
    }
}

