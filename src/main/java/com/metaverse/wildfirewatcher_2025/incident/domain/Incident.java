package com.metaverse.wildfirewatcher_2025.incident.domain;

import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.incident.dto.IncidentRequestDto;
import com.metaverse.wildfirewatcher_2025.zone.domain.Zone;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="incident")
@Entity
public class Incident extends TimeStamped {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;

    @Column
    private String base64Img;

    @Column
    private Boolean isIncidentResolved;

    @Column
    private String incidentType;

    public Incident(Zone zone, String base64Img, Boolean isIncidentResolved, String incidentType) {
        this.zone = zone;
        this.base64Img = base64Img;
        this.isIncidentResolved = isIncidentResolved;
        this.incidentType = incidentType;
    }

    public void updateIsIncidentResolved(boolean isIncidentResolved){
        this.isIncidentResolved = isIncidentResolved;
    }
}
