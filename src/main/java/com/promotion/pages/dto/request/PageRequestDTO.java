package com.promotion.pages.dto.request;

// src/main/java/com/example/demo/dto/PageRequestDTO.java
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    private String url;
    private List<MetaRequestDTO> metas;
    private List<TagRequestDTO> tags;
}

