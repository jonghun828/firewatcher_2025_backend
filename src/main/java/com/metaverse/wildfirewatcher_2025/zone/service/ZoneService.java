package com.metaverse.wildfirewatcher_2025.zone.service;

import com.metaverse.wildfirewatcher_2025.zone.domain.Zone;
import com.metaverse.wildfirewatcher_2025.zone.dto.ZoneRequestDto;
import com.metaverse.wildfirewatcher_2025.zone.dto.ZoneResponseDto;
import com.metaverse.wildfirewatcher_2025.zone.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ZoneService {
    private final ZoneRepository zoneRepository;

    @Autowired
    public ZoneService(ZoneRepository zoneRepository) { this.zoneRepository = zoneRepository; }

    @Transactional(readOnly = true)
    public List<ZoneResponseDto> getZoneSingleArea(int area_id) {
        List<ZoneResponseDto> ZoneSingleAreaList = zoneRepository.findByAreaId(area_id).stream().map(ZoneResponseDto::new).toList();
        return ZoneSingleAreaList;
    }

    @Transactional
    public ZoneResponseDto createZone(ZoneRequestDto zoneRequestDto) {
        Zone zone = new Zone(
                zoneRequestDto.getAreaId(),
                zoneRequestDto.getDeviceType(),
                zoneRequestDto.getAreaName(),
                zoneRequestDto.getAreaIpAddress()
        );

        Zone savedZone = zoneRepository.save(zone);

        ZoneResponseDto zoneResponseDto = new ZoneResponseDto(savedZone);
        return zoneResponseDto;
    }

    @Transactional
    public ZoneResponseDto updateZone(Long id, ZoneRequestDto zoneRequestDto) {
        Zone zone = findZone(id);
        zone.update(zoneRequestDto);
        return new ZoneResponseDto(zone);
    }

    @Transactional
    public void deleteZone(Long id) {
        Zone zone = findZone(id);
        zoneRepository.delete(zone);
    }

    public Zone findZone(Long id) {
        return zoneRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 Zone은 존재하지 않습니다.")
        );
    }

}
