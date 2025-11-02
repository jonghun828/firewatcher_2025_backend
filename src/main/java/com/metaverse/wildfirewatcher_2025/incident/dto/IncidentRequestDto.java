package com.metaverse.wildfirewatcher_2025.incident.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentRequestDto {
    private Long zone_id;
    private String base64Img;
    private Boolean isIncidentResolved;
    private String incidentType;
}
