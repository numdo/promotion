package com.promotion.pages.dto.request;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagRequestDTO {
    private Long id;
    private String tagId;
    private String src;
    private String value;
    private String href;
    private String cssClass;
    private String content;
    private String alt;
    private String title;
}

