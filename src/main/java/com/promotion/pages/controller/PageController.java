package com.promotion.pages.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.promotion.pages.dto.request.PageRequestDTO;
import com.promotion.pages.dto.response.PageResponseDTO;
import com.promotion.pages.service.PageService;

//src/main/java/com/promotion/controller/PageController.java

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pages")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class PageController {

    private final PageService pageService;

    // 생성(Create)
    @PostMapping
    public ResponseEntity<PageResponseDTO> createPage(@RequestBody PageRequestDTO requestDTO) {
        PageResponseDTO responseDTO = pageService.createPage(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // 조회(Read) - 전체
    @GetMapping
    public ResponseEntity<List<PageResponseDTO>> getAllPages() {
        List<PageResponseDTO> responseDTOs = pageService.getAllPages();
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/subcategory/{subCategoryId}")
    public ResponseEntity<List<PageResponseDTO>> getPagesBySubCategory(@PathVariable Long subCategoryId) {
        List<PageResponseDTO> responseDTOs = pageService.getPagesBySubCategory(subCategoryId);
        return ResponseEntity.ok(responseDTOs);
    }

    // 조회(Read) - 단일
    @GetMapping("/{id}")
    public ResponseEntity<PageResponseDTO> getPageById(@PathVariable Long id) {
        PageResponseDTO responseDTO = pageService.getPageById(id);
        return ResponseEntity.ok(responseDTO);
    }

    // 수정(Update)
    @PutMapping("/{id}")
    public ResponseEntity<PageResponseDTO> updatePage(@PathVariable Long id, @RequestBody PageRequestDTO requestDTO) {
        PageResponseDTO responseDTO = pageService.updatePage(id, requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // 삭제(Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        pageService.deletePage(id);
        return ResponseEntity.noContent().build();
    }
}
