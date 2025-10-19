package com.metaverse.wildfirewatcher_2025.comment.repository;
import com.metaverse.wildfirewatcher_2025.comment.domain.Comment;


import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();

    List<Comment> findByNoticeIdOrderByCreatedAtDesc(Long noticeId);
    Optional<Comment> findByIdAndNoticeId(Long commentId, Long noticeId);
}
