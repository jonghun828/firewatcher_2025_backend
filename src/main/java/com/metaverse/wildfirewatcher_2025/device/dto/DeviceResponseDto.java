package com.metaverse.wildfirewatcher_2025.device.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.device.domain.Device;

import java.time.LocalDateTime;

public class DeviceResponseDto extends TimeStamped {
    private Long id;
    private String device_type;
    private int dust_voltage;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedAt;

    public DeviceResponseDto (Device device) {
        this.id = device.getId();
        this.device_type = device.getDevice_type();
        this.dust_voltage = device.getDust_voltage();
        this.status = device.getStatus();
        this.createdAt = device.getCreatedAt();
        this.modifiedAt = device.getModifiedAt();
    }
}
