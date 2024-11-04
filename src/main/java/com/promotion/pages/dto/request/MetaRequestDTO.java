package com.promotion.pages.dto.request;
// src/main/java/com/example/demo/dto/MetaDTO.java

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetaRequestDTO {
    private Long id;
    private String name;
    private String property;
    private String content;
    private String itemprop;
}

