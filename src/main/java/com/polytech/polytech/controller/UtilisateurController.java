package com.polytech.polytech.controller;

import com.polytech.polytech.dto.UtilisateurDto;
import com.polytech.polytech.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    public ResponseEntity<UtilisateurDto> creer(@RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto created = utilisateurService.creer(utilisateurDto);
        return ResponseEntity.created(URI.create("/api/utilisateurs/" + created.getIdentifiant()))
                .body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> recupererParId(@PathVariable Long id) {
        return ResponseEntity.ok(utilisateurService.recupererParId(id));
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> recupererTous() {
        return ResponseEntity.ok(utilisateurService.recupererTous());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> modifier(
            @PathVariable Long id,
            @RequestBody UtilisateurDto utilisateurDto) {
        return ResponseEntity.ok(utilisateurService.modifier(id, utilisateurDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        utilisateurService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
