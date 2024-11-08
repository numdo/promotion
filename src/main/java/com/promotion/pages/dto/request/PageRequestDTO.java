package com.promotion.pages.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    private Long subCategoryId;
    private String title;
    private String content;
}

