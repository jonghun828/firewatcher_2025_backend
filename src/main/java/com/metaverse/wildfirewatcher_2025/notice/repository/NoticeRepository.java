package com.metaverse.wildfirewatcher_2025.notice.repository;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findAllByOrderByCreatedAtDesc();
    Page<Notice> findAll(Pageable pageable);
}
