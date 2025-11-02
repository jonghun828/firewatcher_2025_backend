package com.metaverse.wildfirewatcher_2025.incident.controller;

import com.metaverse.wildfirewatcher_2025.incident.domain.Incident;
import com.metaverse.wildfirewatcher_2025.incident.dto.IncidentRequestDto;
import com.metaverse.wildfirewatcher_2025.incident.dto.IncidentResponseDto;
import com.metaverse.wildfirewatcher_2025.incident.service.IncidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncidentController {
    private IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/incident")
    public ResponseEntity<List<IncidentResponseDto>> getIncidents() {
        List<IncidentResponseDto> incidentResponseDtoList = incidentService.getIncidents();
        return ResponseEntity.ok(incidentResponseDtoList);
    }

    @GetMapping("/incident/{incident_id}")
        public ResponseEntity<IncidentResponseDto> getIncidentOne(@PathVariable Long incident_id) {
            IncidentResponseDto incidentResponseDto = incidentService.getOneIncident(incident_id);
        return ResponseEntity.ok(incidentResponseDto);
    }

    @PostMapping("/incident")
    public ResponseEntity<IncidentResponseDto>  createIncident(@RequestBody IncidentRequestDto incidentRequestDto) {
        IncidentResponseDto incidentResponseDto = incidentService.saveIncident(incidentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(incidentResponseDto);
    }

    @PutMapping("/incident/{incident_id}")
    public ResponseEntity<IncidentResponseDto> editIncident(
            @PathVariable Long incident_id,
            @RequestBody IncidentRequestDto incidentRequestDto) {
        IncidentResponseDto updatedIncidentResponseDto = incidentService.updateIncident(incident_id,incidentRequestDto);
        return ResponseEntity.ok(updatedIncidentResponseDto);
    }

}
