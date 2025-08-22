package com.metaverse.wildfirewatcher_2025.notice.controller;

import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeRequestDto;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    //test
    @GetMapping("/test")
    public String noticeTest(){
        return("asdf");
    }

    @GetMapping("/getnotices")
    public List<NoticeResponseDto> getNoticess(){
        return noticeService.getNoticess();
    }

    //공지사항 전체 불러오기
    @GetMapping("/notices")
    public ResponseEntity<NoticeResponseDto> getNotices(
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<NoticeResponseDto> noticeResponseDtoPage = noticeService.getNotices(pageable);
        return ResponseEntity.ok((NoticeResponseDto) noticeResponseDtoPage);
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
    public Long updateNotice(
        @PathVariable Long id,
        @RequestBody NoticeRequestDto noticeRequestDto){
        return noticeService.updateNotice(id, noticeRequestDto);
    }

    //공지사항 삭제
    @DeleteMapping("/notices/{id}")
    public Long deleteNotice(@PathVariable Long id){
        return noticeService.deleteNotice(id);
    }
}
