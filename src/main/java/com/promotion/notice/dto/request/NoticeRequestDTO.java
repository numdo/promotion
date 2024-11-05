package com.promotion.notice.dto.request;

// src/main/java/com/example/demo/dto/NoticeRequestDTO.java

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequestDTO {
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
