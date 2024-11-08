package com.promotion.contact.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponseDTO {
    private Long id;
    private String name;
    private String contact;
    private String inquiry;
    private String date;
    private String createdAt;

}
