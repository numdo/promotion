package com.promotion.pages.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.promotion.global.exception.ResourceNotFoundException;
import com.promotion.pages.dto.request.MainCategoryRequestDTO;
import com.promotion.pages.dto.response.MainCategoryResponseDTO;
import com.promotion.pages.model.MainCategory;
import com.promotion.pages.repository.MainCategoryRepository;

//src/main/java/com/promotion/service/MainCategoryService.java

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainCategoryService {

 private final MainCategoryRepository mainCategoryRepository;

 // 생성(Create)
 public MainCategoryResponseDTO createMainCategory(MainCategoryRequestDTO requestDTO) {
     MainCategory mainCategory = new MainCategory();
     mainCategory.setName(requestDTO.getName());
     mainCategory.setDescription(requestDTO.getDescription());

     MainCategory savedCategory = mainCategoryRepository.save(mainCategory);
     return new MainCategoryResponseDTO(savedCategory);
 }

 // 조회(Read) - 전체
 public List<MainCategoryResponseDTO> getAllMainCategories() {
     return mainCategoryRepository.findAll()
             .stream()
             .map(MainCategoryResponseDTO::new)
             .collect(Collectors.toList());
 }

 // 조회(Read) - 단일
 public MainCategoryResponseDTO getMainCategoryById(Long id) {
     MainCategory mainCategory = mainCategoryRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("MainCategory not found with id: " + id));
     return new MainCategoryResponseDTO(mainCategory);
 }

 // 수정(Update)
 public MainCategoryResponseDTO updateMainCategory(Long id, MainCategoryRequestDTO requestDTO) {
     MainCategory mainCategory = mainCategoryRepository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("MainCategory not found with id: " + id));

     mainCategory.setName(requestDTO.getName());
     mainCategory.setDescription(requestDTO.getDescription());

     MainCategory updatedCategory = mainCategoryRepository.save(mainCategory);
     return new MainCategoryResponseDTO(updatedCategory);
 }

 // 삭제(Delete)
 public void deleteMainCategory(Long id) {
     mainCategoryRepository.deleteById(id);
 }
}
