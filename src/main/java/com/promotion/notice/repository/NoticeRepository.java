package com.promotion.notice.repository;

import com.promotion.notice.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByUser_UserId(String userId);
}
