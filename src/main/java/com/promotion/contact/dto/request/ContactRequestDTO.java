package com.promotion.contact.dto.request;

// src/main/java/com/example/contactus/dto/InquiryRequest.java


import lombok.*;
import org.hibernate.annotations.processing.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactRequestDTO {

    private String name;

    private String contact;

    private String inquiry;

    private String date;

}
