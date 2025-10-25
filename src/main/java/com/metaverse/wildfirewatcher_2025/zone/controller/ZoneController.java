package com.metaverse.wildfirewatcher_2025.zone.controller;

import com.metaverse.wildfirewatcher_2025.auth.domain.PrincipalDetails;
import com.metaverse.wildfirewatcher_2025.zone.dto.ZoneRequestDto;
import com.metaverse.wildfirewatcher_2025.zone.dto.ZoneResponseDto;
import com.metaverse.wildfirewatcher_2025.zone.service.ZoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ZoneController {
    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping("/zone/{area_id}")
    public ResponseEntity<List<ZoneResponseDto>> getZoneSingleArea(@PathVariable int area_id) {

        List<ZoneResponseDto> ZoneSingleAreaList = zoneService.getZoneSingleArea(area_id);
        return ResponseEntity.ok(ZoneSingleAreaList);
    }

    @PostMapping("/zone")
    public ResponseEntity<ZoneResponseDto> createZone(
            @RequestBody ZoneRequestDto zoneRequestDto,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        ZoneResponseDto ZoneResponseDto = zoneService.createZone(zoneRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ZoneResponseDto);
    }

    @PutMapping("/zone/{zone_id}")
    public ResponseEntity<ZoneResponseDto> updateZone(
            @PathVariable Long zone_id,
            @RequestBody ZoneRequestDto zoneRequestDto){
        ZoneResponseDto updatedZone = zoneService.updateZone(zone_id, zoneRequestDto);
        return ResponseEntity.ok(updatedZone);
    }

    @DeleteMapping("/zone/{zone_id}")
    public ResponseEntity<Void> deleteZone(@PathVariable Long zone_id){
        zoneService.deleteZone(zone_id);
        return ResponseEntity.noContent().build();
    }

}
