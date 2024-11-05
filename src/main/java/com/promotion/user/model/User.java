package com.promotion.user.model;

import com.promotion.notice.model.Notice;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true, length = 100)
    private String userId;

    @Column(name = "user_password", nullable = false, length = 200)
    private String userPassword;

    @Column(name = "role", nullable = false, length = 32)
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notice> notices;
}
