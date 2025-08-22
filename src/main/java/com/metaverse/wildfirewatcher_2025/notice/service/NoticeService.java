package com.metaverse.wildfirewatcher_2025.notice.service;

import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeRequestDto;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {this.noticeRepository = noticeRepository;}

    //테스트
    public List<NoticeResponseDto> getNoticess(){
        List<NoticeResponseDto> responseList = noticeRepository.findAllByOrderByCreatedAtDesc().stream().map(NoticeResponseDto::new).toList();
        return responseList;
    }

    //공지사항 전체 조회.
    @Transactional(readOnly = true)
    public Page<NoticeResponseDto> getNotices(Pageable pageable) {
        Page<Notice> noticePage = noticeRepository.findAll(pageable);
        return noticePage.map(NoticeResponseDto::new);
    }

    //공지사항 생성.
    public NoticeResponseDto createNotice(NoticeRequestDto noticeRequestDto) {
        Notice notice = new Notice(noticeRequestDto);
        Notice savedNotice = noticeRepository.save(notice);

        NoticeResponseDto noticeResponseDto = new NoticeResponseDto(savedNotice);
        return noticeResponseDto;
    }

    //공지사항 수정.
    @Transactional
    public Long updateNotice(Long id, NoticeRequestDto noticeRequestDto) {
        Notice notice = findNotice(id);
        notice.update(noticeRequestDto);
        return id;
    }

    //공지사항 삭제.
    public Long deleteNotice(Long id) {
        Notice notice = findNotice(id);
        noticeRepository.delete(notice);
        return id;
    }

    private Notice findNotice(Long id) {
        return noticeRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
    }
}
