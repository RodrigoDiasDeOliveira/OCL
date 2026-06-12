package com.triminds.integration.mapper;

import com.triminds.rfid.model.RfidEvent;
import com.triminds.integration.dto.RfidEventDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IntegrationMapper {

    public RfidEvent toEntity(RfidEventDTO dto) {
        RfidEvent entity = new RfidEvent();
        entity.setTagId(dto.getTagId());
        entity.setLocation(dto.getLocation());
        entity.setAction(dto.getAction());
        entity.setItem(dto.getItem());
        entity.setTimestamp(dto.getTimestamp() != null ? dto.getTimestamp() : java.time.LocalDateTime.now());
        return entity;
    }

    public RfidEventDTO toDTO(RfidEvent entity) {
        RfidEventDTO dto = new RfidEventDTO();
        dto.setTagId(entity.getTagId());
        dto.setLocation(entity.getLocation());
        dto.setAction(entity.getAction());
        dto.setItem(entity.getItem());
        dto.setTimestamp(entity.getTimestamp());
        return dto;
    }

    public List<RfidEvent> toEntityList(List<RfidEventDTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<RfidEventDTO> toDTOList(List<RfidEvent> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}