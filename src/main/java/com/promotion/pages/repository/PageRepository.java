package com.promotion.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promotion.pages.model.Page;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>{
    List<Page> findBySubCategoryId(Long subCategoryId);

}
