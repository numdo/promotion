package com.promotion.pages.dto.response;

import com.promotion.pages.model.MainCategory;

//src/main/java/com/promotion/dto/response/MainCategoryResponseDTO.java

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MainCategoryResponseDTO {
 private Long id;
 private String name;
 private String description;

 public MainCategoryResponseDTO(MainCategory mainCategory) {
     this.id = mainCategory.getId();
     this.name = mainCategory.getName();
     this.description = mainCategory.getDescription();
 }
}
