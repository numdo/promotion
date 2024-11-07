package com.promotion.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promotion.pages.model.SubCategory;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long>{
    List<SubCategory> findByMainCategoryId(Long mainCategoryId);

}
