package com.promotion.pages.dto.response;
// src/main/java/com/example/demo/dto/MetaResponseDTO.java

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaResponseDTO {
    private Long id;
    private String name;
    private String property;
    private String content;
    private String itemprop;
}
