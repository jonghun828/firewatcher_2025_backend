package com.metaverse.wildfirewatcher_2025.comment.service;

import com.metaverse.wildfirewatcher_2025.auth.domain.PrincipalDetails;
import com.metaverse.wildfirewatcher_2025.auth.domain.User;
import com.metaverse.wildfirewatcher_2025.comment.domain.Comment;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentRequestDto;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentResponseDto;
import com.metaverse.wildfirewatcher_2025.comment.repository.CommentRepository;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import com.metaverse.wildfirewatcher_2025.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final NoticeService noticeService;

    //댓글 생성.
    @Transactional
    public CommentResponseDto createComment(Long notice_id, PrincipalDetails principalDetails , CommentRequestDto commentRequestDto) {
        Notice notice = noticeService.getVaildNotice(notice_id);
        User logined_user = principalDetails.getUser();

        Comment comment;
        comment = new Comment(
            commentRequestDto.getContent(),
            notice,
            logined_user
        );

        Comment savedComment = commentRepository.save(comment);
        return new CommentResponseDto(savedComment);
    }

    //게시글 ID로 댓글 불러오기.
    @Transactional(readOnly = true)
    public List<CommentResponseDto> getCommentsByNoticeId(Long noticeId) {
        noticeService.getNoticeById(noticeId);

        return commentRepository.findByNoticeIdOrderByCreatedAtDesc(noticeId).stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CommentResponseDto getCommentsById(Long noticeId, Long comment_id) {
        return null;
    }

    //댓글 수정.
    @Transactional
    public CommentResponseDto updateComment(Long noticeId, Long comment_id, PrincipalDetails principalDetails, CommentRequestDto commentRequestDto) {
        Comment comment = getValidComment(noticeId, comment_id);
        checkArticleOwnership(comment, principalDetails);
        comment.update(commentRequestDto.getContent());
        return new CommentResponseDto(comment);
    }

    //댓글 삭제.
    @Transactional
    public void deleteComment(Long noticeId, Long comment_id, PrincipalDetails principalDetails, CommentRequestDto commentRequestDto) {
        Comment comment = getValidComment(noticeId, comment_id);
        checkArticleOwnership(comment, principalDetails);
        commentRepository.delete(comment);
    }

    //부모댓글 대댓글 동일 게시글에 있는지 여부 확인.
    private Comment getValidParentComment(Long parentCommentId, Notice notice) {
        Comment parentComment = commentRepository.findById(parentCommentId)
                .orElseThrow(() -> new IllegalArgumentException("부모 댓글을 찾을 수 없습니다. Comment ID: " + parentCommentId));

        if (!parentComment.getNotice().getId().equals(notice.getId())) {
            throw new IllegalArgumentException("대댓글은 부모 댓글과 동일한 게시글에 속해야 합니다.");
        }
        return parentComment;
    }

    //valid한 댓글 여부 확인.
    public Comment getValidComment(Long noticeId, Long comment_id) {
        noticeService.getVaildNotice(noticeId);

        return commentRepository.findByIdAndNoticeId(comment_id, noticeId).orElseThrow(() ->
                new IllegalArgumentException("게시글(ID: " + noticeId + ")에서 댓글(ID: " + comment_id + ")을 찾을 수 없습니다.")
        );
    }

    //작성자 동일 여부 확인.
    private void checkArticleOwnership(Comment comment, PrincipalDetails principalDetails) {
        if (!comment.getUser().getUserId().equals(principalDetails.getUser().getUserId())) {
            throw new IllegalArgumentException("댓글은 작성자만 수정하거나 삭제할 수 있습니다.");
        }
    }

}
