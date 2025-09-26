package com.metaverse.wildfirewatcher_2025.notice.controller;

import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeRequestDto;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    //공지사항 전체 불러오기
    @GetMapping("/notices")
    public ResponseEntity<List<NoticeResponseDto>> getNotices(){

        List<NoticeResponseDto> noticesList = noticeService.getNotices();
        return ResponseEntity.ok((noticesList));
    }

    //공지시항 id를 통해 불러오기
    @GetMapping("/notices/{id}")
    public ResponseEntity<NoticeResponseDto> getNoticeId(){
        return null;
    }

    //공지사항 작성
    @PostMapping("/notices")
    public ResponseEntity<NoticeResponseDto> createNotice(@RequestBody NoticeRequestDto noticeRequestDto){
        NoticeResponseDto noticeResponseDto = noticeService.createNotice(noticeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(noticeResponseDto);
    }

    //공지사항 수정
    @PutMapping("/notices/{id}")
    public ResponseEntity<NoticeResponseDto> updateNotice(
        @PathVariable Long id,
        @RequestBody NoticeRequestDto noticeRequestDto){
        NoticeResponseDto updatedNotice = noticeService.updateNotice(id, noticeRequestDto);
        return ResponseEntity.ok(updatedNotice);
    }

    //공지사항 삭제
    @DeleteMapping("/notices/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id){
        noticeService.deleteNotice(id);
        return ResponseEntity.noContent().build();
    }
}
