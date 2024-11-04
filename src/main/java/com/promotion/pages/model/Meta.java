package com.promotion.pages.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @Column(length = 200)
    private String name;

    @Column(length = 200)
    private String property;

    @Column(length = 1000)
    private String content;

    @Column(length = 100)
    private String itemprop;
}
