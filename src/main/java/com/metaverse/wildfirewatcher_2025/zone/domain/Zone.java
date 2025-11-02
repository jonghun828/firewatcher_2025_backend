package com.metaverse.wildfirewatcher_2025.zone.domain;

import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.zone.dto.ZoneRequestDto;
import com.metaverse.wildfirewatcher_2025.zone.dto.ZoneResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name="zone")
@Entity
public class Zone extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int areaId;

    @Column
    private String deviceType;

    @Column
    private String areaName;

    @Column
    private String areaIpAddress;

    public Zone(int area_id, String deviceType, String area_name, String area_ip_address) {
        this.areaId = area_id;
        this.deviceType = deviceType;
        this.areaName = area_name;
        this.areaIpAddress = area_ip_address;
    }

    public void update(ZoneRequestDto zoneRequestDto){
        this.areaId = zoneRequestDto.getAreaId();
        this.deviceType = zoneRequestDto.getDeviceType();
        this.areaName = zoneRequestDto.getAreaName();
        this.areaIpAddress = zoneRequestDto.getAreaIpAddress();
    }
}
