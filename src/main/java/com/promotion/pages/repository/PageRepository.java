package com.promotion.pages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.promotion.pages.model.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>{

}
