package com.promotion.user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String userId;

    @Column(nullable = false, length = 200)
    private String userPassword;

    @Column(nullable = false, length = 32)
    private String role;
}
