package com.metaverse.wildfirewatcher_2025.device.repository;

import com.metaverse.wildfirewatcher_2025.device.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
