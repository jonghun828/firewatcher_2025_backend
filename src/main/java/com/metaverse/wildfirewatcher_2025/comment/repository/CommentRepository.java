package com.metaverse.wildfirewatcher_2025.comment.repository;
import com.metaverse.wildfirewatcher_2025.comment.domain.Comment;


import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();
}
