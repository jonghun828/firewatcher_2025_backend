package com.metaverse.wildfirewatcher_2025.comment.controller;

import com.metaverse.wildfirewatcher_2025.comment.dto.CommentRequestDto;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.service.NoticeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final NoticeService noticeService;
    public CommentController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    //한게시글 전체 불러오기
    @GetMapping("/notices/{notice_id}/comments")
    public ResponseEntity<NoticeResponseDto> getComment(Long notice_id){
        return null;
    }

    @PostMapping("/notices/{notice_id}/comments")
    public ResponseEntity<NoticeResponseDto> createComment(@RequestBody CommentRequestDto commentRequestDto){
        return null;
    }

    @PutMapping("/notices/{notice_id}/comments/{comment_id}")
    public ResponseEntity<NoticeResponseDto> updateComment(@RequestBody CommentRequestDto commentRequestDto){
        return null;
    }

    @DeleteMapping("/notices/{notice_id}/comments/{comment_id}")
    public ResponseEntity<NoticeResponseDto> deleteComment(Long comment_id){
        return null;
    }
}
