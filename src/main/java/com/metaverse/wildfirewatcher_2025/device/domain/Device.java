package com.metaverse.wildfirewatcher_2025.device.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.metaverse.wildfirewatcher_2025.common.domain.TimeStamped;
import com.metaverse.wildfirewatcher_2025.device.dto.DeviceRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="device")
@Entity
public class Device extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String device_type;

    @Column
    private int dust_voltage;

    @Column
    private String status;

    public Device(DeviceRequestDto deviceRequestDto){
        this.device_type = deviceRequestDto.getDevice_type();
        this.dust_voltage = deviceRequestDto.getDust_voltage();
        this.status = deviceRequestDto.getStatus();
    }
}

