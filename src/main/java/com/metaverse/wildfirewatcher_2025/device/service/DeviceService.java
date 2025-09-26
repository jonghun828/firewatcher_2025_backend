package com.metaverse.wildfirewatcher_2025.device.service;

import com.metaverse.wildfirewatcher_2025.device.domain.Device;
import com.metaverse.wildfirewatcher_2025.device.dto.DeviceRequestDto;
import com.metaverse.wildfirewatcher_2025.device.dto.DeviceResponseDto;
import com.metaverse.wildfirewatcher_2025.device.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public DeviceResponseDto uploadDustInfo(DeviceRequestDto deviceRequestDto) {
        Device device = new Device(deviceRequestDto);
        Device savedDevice = deviceRepository.save(device);

        DeviceResponseDto deviceResponseDto = new DeviceResponseDto(savedDevice);
        return deviceResponseDto;
    }
}
