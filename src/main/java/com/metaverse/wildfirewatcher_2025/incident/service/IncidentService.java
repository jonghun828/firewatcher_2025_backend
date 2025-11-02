package com.metaverse.wildfirewatcher_2025.incident.service;

import com.metaverse.wildfirewatcher_2025.incident.domain.Incident;
import com.metaverse.wildfirewatcher_2025.incident.dto.IncidentRequestDto;
import com.metaverse.wildfirewatcher_2025.incident.dto.IncidentResponseDto;
import com.metaverse.wildfirewatcher_2025.incident.repository.IncidentRepository;
import com.metaverse.wildfirewatcher_2025.notice.dto.NoticeResponseDto;
import com.metaverse.wildfirewatcher_2025.zone.domain.Zone;
import com.metaverse.wildfirewatcher_2025.zone.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentService {
    private final IncidentRepository incidentRepository;
    private final ZoneService zoneService;

    //전체 사건 조회.
    @Transactional(readOnly = true)
    public List<IncidentResponseDto> getIncidents() {
        List<IncidentResponseDto> incidentList = incidentRepository.findAllByOrderByCreatedAtDesc().stream().map(IncidentResponseDto::new).toList();
        return incidentList;
    }

    //특정 사건 조회.
    @Transactional(readOnly = true)
    public IncidentResponseDto getOneIncident(Long id) {
        IncidentResponseDto incident = incidentRepository.findIncidentById(id);
        return incident;
    }

    //사건 게시.
    @Transactional
    public IncidentResponseDto saveIncident(IncidentRequestDto incidentRequestDto) {
        Zone zone = zoneService.findZone(incidentRequestDto.getZone_id());
        Incident incident = new  Incident(
                zone,
                incidentRequestDto.getBase64Img(),
                incidentRequestDto.getIsIncidentResolved(),
                incidentRequestDto.getIncidentType()
        );

        Incident savedIncident = incidentRepository.save(incident);
        return new IncidentResponseDto(savedIncident);
    }

    //사건 수정.
    @Transactional
    public IncidentResponseDto updateIncident(Long incident_id, IncidentRequestDto incidentRequestDto) {
        Incident incident = findIncident(incident_id);
        incident.updateIsIncidentResolved(incidentRequestDto.getIsIncidentResolved());
        return new IncidentResponseDto(incident);
    }

    public Incident findIncident(Long id) {
        return incidentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 사건은 존재하지 않습니다.")
        );
    }
}
