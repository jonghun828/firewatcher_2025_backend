package com.metaverse.wildfirewatcher_2025.device.controller;


import com.metaverse.wildfirewatcher_2025.device.domain.Device;
import com.metaverse.wildfirewatcher_2025.device.dto.DeviceRequestDto;
import com.metaverse.wildfirewatcher_2025.device.dto.DeviceResponseDto;
import com.metaverse.wildfirewatcher_2025.device.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //먼지 센서 POST
    @PostMapping("/device/dust")
    public ResponseEntity<DeviceResponseDto> getDustSensorInfo(@RequestBody DeviceRequestDto deviceRequestDto) {
        DeviceResponseDto deviceResponseDto = deviceService.uploadDustInfo(deviceRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceResponseDto);
    }
}
