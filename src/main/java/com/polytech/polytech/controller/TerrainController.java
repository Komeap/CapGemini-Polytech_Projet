package com.polytech.polytech.controller;

import com.polytech.polytech.dto.TerrainDto;
import com.polytech.polytech.service.TerrainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/terrains")
public class TerrainController {

    private final TerrainService terrainService;

    public TerrainController(TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @PostMapping
    public ResponseEntity<TerrainDto> creer(@RequestBody TerrainDto terrainDto) {
        TerrainDto created = terrainService.creerTerrain(terrainDto);
        return ResponseEntity.created(URI.create("/api/terrains/" + created.getIdentifiant()))
                .body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerrainDto> recupererParId(@PathVariable Long id) {
        return ResponseEntity.ok(terrainService.recupererParId(id));
    }

    @GetMapping
    public ResponseEntity<List<TerrainDto>> recupererTous() {
        return ResponseEntity.ok(terrainService.recupererTous());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TerrainDto> modifier(
            @PathVariable Long id,
            @RequestBody TerrainDto terrainDto) {
        return ResponseEntity.ok(terrainService.modifier(id, terrainDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        terrainService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
