package com.promotion.pages.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @Column(length = 100)
    private String tagId; // SQL 예약어 충돌 방지를 위해 이름 변경

    @Column(length = 300)
    private String src;

    @Column(length = 1000)
    private String value;

    @Column(length = 300)
    private String href;

    @Column(length = 200)
    private String cssClass; // Java 예약어 충돌 방지를 위해 이름 변경

    @Column(length = 1000)
    private String content;

    @Column(length = 200)
    private String alt;

    @Column(length = 200)
    private String title;
}
