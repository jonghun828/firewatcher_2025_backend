package com.metaverse.wildfirewatcher_2025.comment.service;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentRequestDto;
import com.metaverse.wildfirewatcher_2025.comment.dto.CommentResponseDto;
import com.metaverse.wildfirewatcher_2025.comment.repository.CommentRepository;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.notice.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final NoticeRepository noticeRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, NoticeRepository noticeRepository) {
        this.commentRepository = commentRepository;
        this.noticeRepository = noticeRepository;
    }

//    @Transactional(readOnly = true)
//    public List<CommentResponseDto> getComments(){
//        List<CommentResponseDto> ListCommentsAll = commentRepository.findAllByOrderByCreatedAtDesc().stream().map(NoticeResponseDto::new).toList();;
//        return ListCommentsAll;
//    }

    @Transactional(readOnly = true)
    public CommentResponseDto getCommentsByNoticeId(Long notice_id){
        return null;
    }

    @Transactional(readOnly = true)
    public CommentResponseDto getCommentsById(Long notice_id, Long comment_id){
        return null;
    }

    @Transactional
    public CommentResponseDto updateComment(Long notice_id, Long comment_id, CommentRequestDto commentRequestDto){
        return null;
    }

    @Transactional
    public CommentResponseDto deleteComment(Long notice_id, Long comment_id){
        return null;
    }
}
