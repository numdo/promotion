package com.promotion.pages.repository;

import com.promotion.pages.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    List<Section> findByPageIdOrderBySectionOrderAsc(Long pageId);
}
