package com.promotion.notice.service;


import com.promotion.notice.dto.request.NoticeRequestDTO;
import com.promotion.notice.dto.response.NoticeResponseDTO;
import com.promotion.notice.model.Notice;
import com.promotion.notice.repository.NoticeRepository;
import com.promotion.user.model.User;
import com.promotion.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoticeService {
    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public NoticeResponseDTO createNotice(NoticeRequestDTO noticeRequestDTO) {
        User user = userRepository.findByUserId("admin") // 관리자만 공지사항 생성 가능
                .orElseThrow(() -> new RuntimeException("관리자를 찾을 수 없습니다."));

        Notice notice = new Notice();
        notice.setTitle(noticeRequestDTO.getTitle());
        notice.setContent(noticeRequestDTO.getContent());
        notice.setCreatedAt(noticeRequestDTO.getCreatedAt());
        notice.setUser(user);

        Notice savedNotice = noticeRepository.save(notice);
        NoticeResponseDTO responseDTO = modelMapper.map(savedNotice, NoticeResponseDTO.class);
        responseDTO.setUserId(user.getUserId());
        return responseDTO;
    }


    public List<NoticeResponseDTO> getAllNotices() {
        List<Notice> notices = noticeRepository.findAll();
        return notices.stream()
                .map(notice -> {
                    NoticeResponseDTO dto = modelMapper.map(notice, NoticeResponseDTO.class);
                    dto.setUserId(notice.getUser().getUserId());
                    return dto;
                })
                .collect(Collectors.toList());
    }


    public NoticeResponseDTO getNoticeById(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("공지사항을 찾을 수 없습니다."));
        NoticeResponseDTO responseDTO = modelMapper.map(notice, NoticeResponseDTO.class);
        responseDTO.setUserId(notice.getUser().getUserId());
        return responseDTO;
    }


    public NoticeResponseDTO updateNotice(Long id, NoticeRequestDTO noticeRequestDTO) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("공지사항을 찾을 수 없습니다."));

        notice.setTitle(noticeRequestDTO.getTitle());
        notice.setContent(noticeRequestDTO.getContent());
        notice.setCreatedAt(noticeRequestDTO.getCreatedAt());

        Notice updatedNotice = noticeRepository.save(notice);
        NoticeResponseDTO responseDTO = modelMapper.map(updatedNotice, NoticeResponseDTO.class);
        responseDTO.setUserId(updatedNotice.getUser().getUserId());
        return responseDTO;
    }


    public void deleteNotice(Long id) {
        if (!noticeRepository.existsById(id)) {
            throw new RuntimeException("공지사항을 찾을 수 없습니다.");
        }
        noticeRepository.deleteById(id);
    }
}
