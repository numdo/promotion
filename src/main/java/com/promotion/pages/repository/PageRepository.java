package com.promotion.pages.repository;

import com.promotion.pages.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PageRepository extends JpaRepository<Page,Long> {
    Optional<Page> findByUrl(String url);
}
