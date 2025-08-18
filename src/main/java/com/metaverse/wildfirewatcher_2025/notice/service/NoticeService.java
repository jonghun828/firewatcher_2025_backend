package com.metaverse.wildfirewatcher_2025.notice.service;

import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
private final NoticeRepository noticeRepository;

//공지사항 전체 조회.
    public Page<NoticeResponseDto> getNotices(Pageable pageable) {
        Page<Notice> noticePage = noticeRepository.findAll(pageable);
        return noticePage.map(NoticeResponseDto::new);
    }
}
