package com.metaverse.wildfirewatcher_2025.notice.repository;

import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findAllByOrderByCreatedAtDesc();

    List<Notice> findAllByTitleContainingIgnoreCase(String keyword);
    List<Notice> findAllByContentContainingIgnoreCase(String keyword);

    NoticeResponseDto findNoticeById(Long id);
}
