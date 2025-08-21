package com.metaverse.wildfirewatcher_2025.notice.controller;

import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeRequestDto;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    //공지사항 전체 불러오기
    @GetMapping("notices/")
    public ResponseEntity<NoticeResponseDto> getNotices(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<NoticeResponseDto> noticeResponseDtoPage = noticeService.getNotices(pageable);
        return ResponseEntity.ok((NoticeResponseDto) noticeResponseDtoPage);
    }

    //공지시항 id를 통해 불러오기
    @GetMapping("notices/{id}")
    public ResponseEntity<NoticeResponseDto> getNoticeId(){
        return null;
    }

    //공지사항 작성
    @PostMapping("notices/")
    public ResponseEntity<NoticeResponseDto> createNotice(){
        return null;
    }

    //공지사항 수정
    @PutMapping("notices/{id}")
    public ResponseEntity<NoticeResponseDto> updateNotice(
        @PathVariable Long id,
        @RequestBody NoticeRequestDto noticeRequestDto){
        return null;
    }

    //공지사항 삭제
    @DeleteMapping("notices/{id}")
    public ResponseEntity<NoticeResponseDto> deleteNotice(
        @PathVariable Long id
    ){
//        NoticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}
