package com.metaverse.wildfirewatcher_2025.notice.service;

import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

interface NoticeRepository extends Repository<Notice, Long> {
    Page<Notice> findAll(Pageable pageable);
}
