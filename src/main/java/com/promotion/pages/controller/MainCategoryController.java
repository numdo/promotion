package com.promotion.pages.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promotion.pages.dto.request.MainCategoryRequestDTO;
import com.promotion.pages.dto.response.MainCategoryResponseDTO;
import com.promotion.pages.service.MainCategoryService;

//src/main/java/com/promotion/controller/MainCategoryController.java

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/main-categories")
@RequiredArgsConstructor
public class MainCategoryController {

 private final MainCategoryService mainCategoryService;

 // 생성(Create)
 @PostMapping
 public ResponseEntity<MainCategoryResponseDTO> createMainCategory(@RequestBody MainCategoryRequestDTO requestDTO) {
     MainCategoryResponseDTO responseDTO = mainCategoryService.createMainCategory(requestDTO);
     return ResponseEntity.ok(responseDTO);
 }

 // 조회(Read) - 전체
 @GetMapping
 public ResponseEntity<List<MainCategoryResponseDTO>> getAllMainCategories() {
     List<MainCategoryResponseDTO> responseDTOs = mainCategoryService.getAllMainCategories();
     return ResponseEntity.ok(responseDTOs);
 }

 // 조회(Read) - 단일
 @GetMapping("/{id}")
 public ResponseEntity<MainCategoryResponseDTO> getMainCategoryById(@PathVariable Long id) {
     MainCategoryResponseDTO responseDTO = mainCategoryService.getMainCategoryById(id);
     return ResponseEntity.ok(responseDTO);
 }

 // 수정(Update)
 @PutMapping("/{id}")
 public ResponseEntity<MainCategoryResponseDTO> updateMainCategory(@PathVariable Long id, @RequestBody MainCategoryRequestDTO requestDTO) {
     MainCategoryResponseDTO responseDTO = mainCategoryService.updateMainCategory(id, requestDTO);
     return ResponseEntity.ok(responseDTO);
 }

 // 삭제(Delete)
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteMainCategory(@PathVariable Long id) {
     mainCategoryService.deleteMainCategory(id);
     return ResponseEntity.noContent().build();
 }
}
