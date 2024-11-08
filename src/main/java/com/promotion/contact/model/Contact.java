package com.promotion.contact.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String contact;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String inquiry;

    @Column(nullable = false)
    private String date; // YYYY-MM-DD 형식의 문자열로 저장

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


    public Contact(String name, String contact, String inquiry, String date) {
    }
}

