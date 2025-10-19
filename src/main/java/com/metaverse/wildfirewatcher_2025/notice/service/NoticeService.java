package com.metaverse.wildfirewatcher_2025.notice.service;

import com.metaverse.wildfirewatcher_2025.auth.domain.User;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeRequestDto;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.repository.NoticeRepository;
import com.metaverse.wildfirewatcher_2025.auth.domain.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeService(NoticeRepository noticeRepository) {this.noticeRepository = noticeRepository;}

    //공지사항 전체 조회.
    @Transactional(readOnly = true)
    public List<NoticeResponseDto> getNotices(){
        List<NoticeResponseDto> responseList = noticeRepository.findAllByOrderByCreatedAtDesc().stream().map(NoticeResponseDto::new).toList();
        return responseList;
    }

    //공지사항 하나 조회.
        @Transactional(readOnly = true)
        public NoticeResponseDto getNoticeById(Long id){
            NoticeResponseDto notice = noticeRepository.findNoticeById(id);
            return notice;
        }

    //공지사항 검색(제목)으로 조회.
    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchNoticesByKeywordTitle(String keyword) {
        List<NoticeResponseDto> responseList = noticeRepository.findAllByTitleContainingIgnoreCase(keyword).stream().map(NoticeResponseDto::new).toList();
        return responseList;
    }

    //공지사항 검색(내용)으로 조회.
    @Transactional(readOnly = true)
    public List<NoticeResponseDto> searchNoticesByKeywordContent(String keyword) {
        List<NoticeResponseDto> responseList = noticeRepository.findAllByContentContainingIgnoreCase(keyword).stream().map(NoticeResponseDto::new).toList();
        return responseList;
    }

    //공지사항 생성.
    @Transactional
    public NoticeResponseDto createNotice(PrincipalDetails principalDetails, NoticeRequestDto noticeRequestDto) {
        User logined_user = principalDetails.getUser();
        Notice notice = new Notice(
            noticeRequestDto.getTitle(),
            noticeRequestDto.getContent(),
            noticeRequestDto.isImportant(),
            logined_user
        );
        Notice savedNotice = noticeRepository.save(notice);

        NoticeResponseDto noticeResponseDto = new NoticeResponseDto(savedNotice);
        return noticeResponseDto;
    }

    //공지사항 수정.
    @Transactional
    public NoticeResponseDto updateNotice(PrincipalDetails principalDetails, Long id, NoticeRequestDto noticeRequestDto) {
        Notice notice = findNotice(id);
        checkArticleOwnership(notice, principalDetails);
        notice.update(noticeRequestDto);
        return new NoticeResponseDto(notice);
    }

    //공지사항 삭제.
    @Transactional
    public void deleteNotice(PrincipalDetails principalDetails, Long id) {
        Notice notice = findNotice(id);
        checkArticleOwnership(notice, principalDetails);
        noticeRepository.delete(notice);
    }

    //게시글 존재 여부 확인.
    private Notice findNotice(Long id) {
        return noticeRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
    }

    //게시글 존재 여부 확인.
    public Notice getVaildNotice(Long id) {
        return noticeRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물은 존재하지 않습니다.")
        );
    }

    //작성자 동일 여부 확인.
    private void checkArticleOwnership(Notice notice, PrincipalDetails principalDetails) {
        if (!notice.getUser().getUser_id().equals(principalDetails.getUser().getUser_id())) {
            throw new IllegalArgumentException("게시글은 작성자만 수정하거나 삭제할 수 있습니다.");
        }
    }
}
