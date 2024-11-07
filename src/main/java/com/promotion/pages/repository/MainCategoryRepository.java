package com.promotion.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promotion.pages.model.MainCategory;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Long>{

}
