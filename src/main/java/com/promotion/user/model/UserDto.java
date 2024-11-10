package com.promotion.user.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true, length = 100)
    private String userId;

    @Column(name = "user_password", nullable = false, length = 200)
    private String password;

    @Column(name = "role", nullable = false, length = 32)
    private String role;

}
