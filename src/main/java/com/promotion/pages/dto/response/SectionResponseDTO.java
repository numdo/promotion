package com.promotion.pages.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionResponseDTO {
    private Long id;
    private String title;
    private String content;
    private Integer sectionOrder;
}
