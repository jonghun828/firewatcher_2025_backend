package com.metaverse.wildfirewatcher_2025.notice.repository;
import com.metaverse.wildfirewatcher_2025.notice.domain.Notice;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
