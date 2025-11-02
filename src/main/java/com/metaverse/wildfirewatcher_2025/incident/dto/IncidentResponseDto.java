package com.metaverse.wildfirewatcher_2025.incident.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.incident.domain.Incident;
import com.metaverse.wildfirewatcher_2025.zone.domain.Zone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IncidentResponseDto extends TimeStamped {
    private Long id;
    private Long zone_id;
    private int area_id;
    private String zone_name;
    private String deviceType;
    private String base64Img;
    private Boolean isIncidentResolved;
    private String incidentType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    public IncidentResponseDto(Incident incident) {
        this.id = incident.getId();
        this.zone_id = incident.getZone().getId();
        this.area_id = incident.getZone().getAreaId();
        this.deviceType = incident.getZone().getDeviceType();
        this.zone_name = incident.getZone().getAreaName();
        this.base64Img = incident.getBase64Img();
        this.isIncidentResolved = incident.getIsIncidentResolved();
        this.incidentType = incident.getIncidentType();

        this.createdAt = incident.getCreatedAt();
        this.modifiedAt = incident.getModifiedAt();
    }

}
