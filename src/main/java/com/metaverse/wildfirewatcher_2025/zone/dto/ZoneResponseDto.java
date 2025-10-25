package com.metaverse.wildfirewatcher_2025.zone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.zone.domain.Zone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZoneResponseDto extends TimeStamped{
    private Long id;
    private int areaId;
    private String deviceType;
    private String areaName;
    private String areaIpAddress;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    public ZoneResponseDto(Zone zone) {
        this.id = zone.getId();
        this.areaId = zone.getAreaId();
        this.deviceType = zone.getDeviceType();
        this.areaName = zone.getAreaName();
        this.areaIpAddress = zone.getAreaIpAddress();
        this.createdAt = zone.getCreatedAt();
        this.modifiedAt = zone.getModifiedAt();
    }
}
