package com.promotion.pages.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryRequestDTO {
    private Long mainCategoryId;
    private String name;
    private String description;
}
