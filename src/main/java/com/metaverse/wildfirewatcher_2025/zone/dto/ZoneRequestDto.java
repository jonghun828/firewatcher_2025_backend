package com.metaverse.wildfirewatcher_2025.zone.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZoneRequestDto {
    private int areaId;
    private String deviceType;
    private String areaName;
    private String areaIpAddress;
}
