package com.metaverse.wildfirewatcher_2025.notice.controller;

import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("notices/")
    public ResponseEntity<NoticeResponseDto> getNotice(){
        return null;
    }

    @GetMapping("notices/{notice_id}")
    public ResponseEntity<NoticeResponseDto> getNoticee(){
        return null;
    }

    @PostMapping("notices/")
    public ResponseEntity<NoticeResponseDto> createNotice(){
        return null;
    }

    @PutMapping("notices/{notice_id}")
    public ResponseEntity<NoticeResponseDto> updateNotice(){
        return null;
    }

    @DeleteMapping("notices/{notice_id}")
    public ResponseEntity<NoticeResponseDto> deleteNotice(){
        return null;
    }
}
