package com.polytech.polytech.service;

import com.polytech.polytech.dto.TerrainDto;
import com.polytech.polytech.entity.Terrain;
import com.polytech.polytech.exception.NotFoundException;
import com.polytech.polytech.mapper.TerrainMapper;
import com.polytech.polytech.repository.TerrainRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerrainService {
    private final TerrainRepository terrainRepository;
    private final TerrainMapper terrainMapper;

    public TerrainService(TerrainRepository terrainRepository, TerrainMapper terrainMapper) {
        this.terrainRepository = terrainRepository;
        this.terrainMapper = terrainMapper;
    }

    public TerrainDto creerTerrain(TerrainDto terrainDto) {
        Terrain terrain = terrainMapper.toEntity(terrainDto);
        return terrainMapper.toDto(terrainRepository.save(terrain));
    }

    public TerrainDto recupererParId(Long id) {
        return terrainMapper.toDto(trouverTerrain(id));
    }

    public List<TerrainDto> recupererTous() {
        return terrainRepository.findAll().stream()
                .map(terrainMapper::toDto)
                .collect(Collectors.toList());
    }

    public TerrainDto modifier(Long id, TerrainDto terrainDto) {
        Terrain terrain = trouverTerrain(id);
        terrainMapper.updateEntity(terrainDto, terrain);
        return terrainMapper.toDto(terrainRepository.save(terrain));
    }

    public void supprimer(Long id) {
        Terrain terrain = trouverTerrain(id);
        terrainRepository.delete(terrain);
    }

    private Terrain trouverTerrain(Long id) {
        return terrainRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Terrain introuvable avec l'identifiant " + id));
    }
}
