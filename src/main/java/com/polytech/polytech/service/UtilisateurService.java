package com.polytech.polytech.service;

import com.polytech.polytech.dto.UtilisateurDto;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.exception.NotFoundException;
import com.polytech.polytech.mapper.UtilisateurMapper;
import com.polytech.polytech.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    public UtilisateurDto creer(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDto);
        return utilisateurMapper.toDto(utilisateurRepository.save(utilisateur));
    }

    public UtilisateurDto recupererParId(Long id) {
        return utilisateurMapper.toDto(trouverUtilisateur(id));
    }

    public List<UtilisateurDto> recupererTous() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    public UtilisateurDto modifier(Long id, UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = trouverUtilisateur(id);
        utilisateurMapper.updateEntity(utilisateurDto, utilisateur);
        return utilisateurMapper.toDto(utilisateurRepository.save(utilisateur));
    }

    public void supprimer(Long id) {
        Utilisateur utilisateur = trouverUtilisateur(id);
        utilisateurRepository.delete(utilisateur);
    }

    private Utilisateur trouverUtilisateur(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Utilisateur introuvable avec l'identifiant " + id));
    }
}
