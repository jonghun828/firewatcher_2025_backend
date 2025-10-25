package com.metaverse.wildfirewatcher_2025.zone.repository;

import com.metaverse.wildfirewatcher_2025.zone.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    List<Zone> findByAreaId(int area_id);
}
