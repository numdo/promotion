package com.promotion.pages.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.promotion.global.exception.ResourceNotFoundException;
import com.promotion.pages.dto.request.PageRequestDTO;
import com.promotion.pages.dto.response.PageResponseDTO;
import com.promotion.pages.model.Page;
import com.promotion.pages.model.SubCategory;
import com.promotion.pages.repository.PageRepository;
import com.promotion.pages.repository.SubCategoryRepository;

//src/main/java/com/promotion/service/PageService.java

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PageService {

 private final PageRepository pageRepository;
 private final SubCategoryRepository subCategoryRepository;

 // 생성(Create)
 public PageResponseDTO createPage(PageRequestDTO requestDTO) {
     SubCategory subCategory = subCategoryRepository.findById(requestDTO.getSubCategoryId())
             .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + requestDTO.getSubCategoryId()));

     Page page = new Page();
     page.setTitle(requestDTO.getTitle());
     page.setContent(requestDTO.getContent());
     page.setSubCategory(subCategory);

     Page savedPage = pageRepository.save(page);
     return new PageResponseDTO(savedPage);
 }

 // 조회(Read) - 전체
 public List<PageResponseDTO> getAllPages() {
     return pageRepository.findAll()
             .stream()
             .map(PageResponseDTO::new)
             .collect(Collectors.toList());
 }

 // 조회(Read) - 단일
 public PageResponseDTO getPageById(Long id) {
     Page page = pageRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Page not found with id: " + id));
     return new PageResponseDTO(page);
 }

 // 수정(Update)
 public PageResponseDTO updatePage(Long id, PageRequestDTO requestDTO) {
     Page page = pageRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Page not found with id: " + id));

     SubCategory subCategory = subCategoryRepository.findById(requestDTO.getSubCategoryId())
             .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id: " + requestDTO.getSubCategoryId()));

     page.setTitle(requestDTO.getTitle());
     page.setContent(requestDTO.getContent());
     page.setSubCategory(subCategory);

     Page updatedPage = pageRepository.save(page);
     return new PageResponseDTO(updatedPage);
 }

 // 삭제(Delete)
 public void deletePage(Long id) {
     pageRepository.deleteById(id);
 }
}
