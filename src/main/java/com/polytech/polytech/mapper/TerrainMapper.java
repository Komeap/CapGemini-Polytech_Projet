package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.TerrainDto;
import com.polytech.polytech.entity.Terrain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = CoordonneesMapper.class)
public interface TerrainMapper {

    TerrainDto toDto(Terrain terrain);

    @Mapping(target = "identifiant", ignore = true)
    @Mapping(target = "utilisateurs", ignore = true)
    Terrain toEntity(TerrainDto terrainDto);

    @Mapping(target = "identifiant", ignore = true)
    @Mapping(target = "utilisateurs", ignore = true)
    void updateEntity(TerrainDto terrainDto, @MappingTarget Terrain terrain);
}
