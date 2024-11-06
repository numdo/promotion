package com.promotion.pages.dto.response;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDTO {
    private Long id;
    private String url;
    private List<MetaResponseDTO> metas;
    private List<SectionResponseDTO> sections; // sections 필드 추가
}
