package com.promotion.notice.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeResponseDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String userId;
}

