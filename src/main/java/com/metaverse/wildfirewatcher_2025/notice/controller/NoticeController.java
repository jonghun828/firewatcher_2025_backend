package com.metaverse.wildfirewatcher_2025.notice.controller;

import com.metaverse.wildfirewatcher_2025.auth.domain.PrincipalDetails;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeRequestDto;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.service.NoticeService;
import com.metaverse.wildfirewatcher_2025.auth.dto.AuthResponseDto;
import com.metaverse.wildfirewatcher_2025.auth.dto.LoginRequestDto;
import com.metaverse.wildfirewatcher_2025.auth.dto.SignUpRequestDto;
import com.metaverse.wildfirewatcher_2025.auth.service.UserService; // AuthService 임포트
import com.metaverse.wildfirewatcher_2025.auth.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    //공지사항 제목 검색으로 불러오기.
    @GetMapping("/notices/search/title")
    public List<NoticeResponseDto> searchNoticesTitle(@RequestParam String keyword) {
        return noticeService.searchNoticesByKeywordTitle(keyword);
    }

    //공지사항 내용 검색으로 불러오기.
    @GetMapping("/notices/search/content")
    public List<NoticeResponseDto> searchNoticesContent(@RequestParam String keyword) {
        return noticeService.searchNoticesByKeywordContent(keyword);
    }

    //공지시항 id를 통해 불러오기.
    @GetMapping("/notices/{id}")
    public ResponseEntity<NoticeResponseDto> getNoticeById(@PathVariable Long id){
        NoticeResponseDto respondedNotice = noticeService.getNoticeById(id);
        return ResponseEntity.ok((respondedNotice));
    }

    //공지사항 작성
    @PostMapping("/notices")
    public ResponseEntity<NoticeResponseDto> createNotice(
            @RequestBody NoticeRequestDto noticeRequestDto,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        NoticeResponseDto noticeResponseDto = noticeService.createNotice(principalDetails, noticeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(noticeResponseDto);
    }

    //공지사항 수정
    @PutMapping("/notices/{id}")
    public ResponseEntity<NoticeResponseDto> updateNotice(
        @PathVariable Long id,
        @RequestBody NoticeRequestDto noticeRequestDto,
        @AuthenticationPrincipal PrincipalDetails principalDetails){
        NoticeResponseDto updatedNotice = noticeService.updateNotice(principalDetails, id, noticeRequestDto);
        return ResponseEntity.ok(updatedNotice);
    }

    //공지사항 삭제
    @DeleteMapping("/notices/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails){
        noticeService.deleteNotice(principalDetails, id);
        return ResponseEntity.noContent().build();
    }
}
