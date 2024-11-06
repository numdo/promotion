package com.promotion.pages.dto.request;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    private Long id;
    private String url;
    private List<MetaRequestDTO> metas;
    private List<SectionRequestDTO> sections; // sections 필드 추가
}
