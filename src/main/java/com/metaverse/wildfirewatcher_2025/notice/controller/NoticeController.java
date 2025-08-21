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

    @GetMapping("notices/")
    public ResponseEntity<NoticeResponseDto> getNotices(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<NoticeResponseDto> noticeResponseDtoPage = noticeService.getNotices(pageable);
        return ResponseEntity.ok((NoticeResponseDto) noticeResponseDtoPage);
    }

    @GetMapping("notices/{id}")
    public ResponseEntity<NoticeResponseDto> getNoticeId(){
        return null;
    }

    @PostMapping("notices/")
    public ResponseEntity<NoticeResponseDto> createNotice(){
        return null;
    }

    @PutMapping("notices/{id}")
    public ResponseEntity<NoticeResponseDto> updateNotice(
        @PathVariable Long id,
        @RequestBody NoticeRequestDto noticeRequestDto){
        return null;
    }

    @DeleteMapping("notices/{id}")
    public ResponseEntity<NoticeResponseDto> deleteNotice(
        @PathVariable Long id
    ){
//        NoticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}
