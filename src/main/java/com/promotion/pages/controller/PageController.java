package com.promotion.pages.controller;

import com.promotion.pages.dto.request.PageRequestDTO;
import com.promotion.pages.dto.response.PageResponseDTO;
import com.promotion.pages.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    @Autowired
    private PageService pageService;

    // 페이지 생성
    @PostMapping
    public ResponseEntity<PageResponseDTO> createPage(@RequestBody PageRequestDTO pageRequestDTO) {
        PageResponseDTO responseDTO = pageService.createPage(pageRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // URL로 페이지 조회
    @GetMapping("/url/{url}")
    public ResponseEntity<PageResponseDTO> getPageByUrl(@PathVariable String url) {
        PageResponseDTO responseDTO = pageService.getPageByUrl(url);
        return ResponseEntity.ok(responseDTO);
    }

    // 모든 페이지 조회
    @GetMapping
    public ResponseEntity<List<PageResponseDTO>> getAllPages() {
        List<PageResponseDTO> pages = pageService.getAllPages();
        return ResponseEntity.ok(pages);
    }

    // 페이지 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<PageResponseDTO> updatePage(@PathVariable Long id, @RequestBody PageRequestDTO pageRequestDTO) {
        PageResponseDTO responseDTO = pageService.updatePage(id, pageRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // 페이지 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePage(@PathVariable Long id) {
        pageService.deletePage(id);
        return ResponseEntity.noContent().build();
    }
}
