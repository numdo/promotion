package com.promotion.pages.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.promotion.pages.dto.request.SubCategoryRequestDTO;
import com.promotion.pages.dto.response.SubCategoryResponseDTO;
import com.promotion.pages.service.SubCategoryService;

//src/main/java/com/promotion/controller/SubCategoryController.java

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sub-categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class SubCategoryController {

 private final SubCategoryService subCategoryService;

 // 생성(Create)
 @PostMapping
 public ResponseEntity<SubCategoryResponseDTO> createSubCategory(@RequestBody SubCategoryRequestDTO requestDTO) {
     SubCategoryResponseDTO responseDTO = subCategoryService.createSubCategory(requestDTO);
     return ResponseEntity.ok(responseDTO);
 }

 // 조회(Read) - 전체
 @GetMapping
 public ResponseEntity<List<SubCategoryResponseDTO>> getAllSubCategories() {
     List<SubCategoryResponseDTO> responseDTOs = subCategoryService.getAllSubCategories();
     return ResponseEntity.ok(responseDTOs);
 }

 // 조회(Read) - 단일
 @GetMapping("/{id}")
 public ResponseEntity<SubCategoryResponseDTO> getSubCategoryById(@PathVariable Long id) {
     SubCategoryResponseDTO responseDTO = subCategoryService.getSubCategoryById(id);
     return ResponseEntity.ok(responseDTO);
 }

 // 수정(Update)
 @PutMapping("/{id}")
 public ResponseEntity<SubCategoryResponseDTO> updateSubCategory(@PathVariable Long id, @RequestBody SubCategoryRequestDTO requestDTO) {
     SubCategoryResponseDTO responseDTO = subCategoryService.updateSubCategory(id, requestDTO);
     return ResponseEntity.ok(responseDTO);
 }

 // 삭제(Delete)
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteSubCategory(@PathVariable Long id) {
     subCategoryService.deleteSubCategory(id);
     return ResponseEntity.noContent().build();
 }
}
