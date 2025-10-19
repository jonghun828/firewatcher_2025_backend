package com.metaverse.wildfirewatcher_2025.comment.controller;

import com.metaverse.wildfirewatcher_2025.auth.domain.PrincipalDetails;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentRequestDto;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentResponseDto;
import com.metaverse.wildfirewatcher_2025.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //한게시글 전체 불러오기
    @GetMapping("/notices/{notice_id}/comments")
    public ResponseEntity<List<CommentResponseDto>> getComment(@PathVariable Long notice_id){
        List<CommentResponseDto> commentResponseDtoList = commentService.getCommentsByNoticeId(notice_id);
        return ResponseEntity.ok(commentResponseDtoList);
    }

    @PostMapping("/notices/{notice_id}/comments")
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long notice_id,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal PrincipalDetails principalDetails){
        CommentResponseDto commentResponseDto = commentService.createComment(notice_id, principalDetails, commentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponseDto);
    }

    @PutMapping("/notices/{notice_id}/comments/{comment_id}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long notice_id,
            @PathVariable Long comment_id,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal PrincipalDetails principalDetails){
        CommentResponseDto updatedComment = commentService.updateComment(notice_id, comment_id, principalDetails, commentRequestDto);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/notices/{notice_id}/comments/{comment_id}")
    public ResponseEntity<CommentRequestDto> deleteComment(
            @PathVariable Long notice_id,
            @PathVariable Long comment_id,
            @RequestBody CommentRequestDto commentRequestDto,
            @AuthenticationPrincipal PrincipalDetails principalDetails){
        commentService.deleteComment(notice_id, comment_id, principalDetails, commentRequestDto);
        return ResponseEntity.noContent().build();
    }
}
