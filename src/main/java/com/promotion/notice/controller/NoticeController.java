package com.promotion.notice.controller;

import com.promotion.notice.dto.request.NoticeRequestDTO;
import com.promotion.notice.dto.response.NoticeResponseDTO;
import com.promotion.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // 모든 공지사항 조회
    @GetMapping
    public ResponseEntity<List<NoticeResponseDTO>> getAllNotices() {
        List<NoticeResponseDTO> notices = noticeService.getAllNotices();
        return ResponseEntity.ok(notices);
    }

    // 특정 공지사항 조회
    @GetMapping("/{id}")
    public ResponseEntity<NoticeResponseDTO> getNoticeById(@PathVariable Long id) {
        NoticeResponseDTO notice = noticeService.getNoticeById(id);
        return ResponseEntity.ok(notice);
    }

    // 공지사항 생성
    @PostMapping
    public ResponseEntity<NoticeResponseDTO> createNotice(@RequestBody NoticeRequestDTO noticeRequestDTO) {
        NoticeResponseDTO createdNotice = noticeService.createNotice(noticeRequestDTO);
        return new ResponseEntity<>(createdNotice, HttpStatus.CREATED);
    }

    // 공지사항 수정
    @PutMapping("/{id}")
    public ResponseEntity<NoticeResponseDTO> updateNotice(@PathVariable Long id,
                                                          @RequestBody NoticeRequestDTO noticeRequestDTO) {
        NoticeResponseDTO updatedNotice = noticeService.updateNotice(id, noticeRequestDTO);
        return ResponseEntity.ok(updatedNotice);
    }

    // 공지사항 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}
