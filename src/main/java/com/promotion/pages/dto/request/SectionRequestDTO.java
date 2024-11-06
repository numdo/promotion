package com.promotion.pages.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SectionRequestDTO {
    private Long id;
    private String title;
    private String content;
    private Integer sectionOrder;
}
