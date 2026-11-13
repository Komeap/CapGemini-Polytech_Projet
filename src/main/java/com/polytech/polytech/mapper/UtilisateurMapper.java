package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.UtilisateurDto;
import com.polytech.polytech.entity.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    @Mapping(target = "identifiant", source = "identifiant")
    UtilisateurDto toDto(Utilisateur utilisateur);

    @Mapping(target = "identifiant", ignore = true)
    @Mapping(target = "terrainsReserves", ignore = true)
    Utilisateur toEntity(UtilisateurDto utilisateurDto);

    @Mapping(target = "identifiant", ignore = true)
    @Mapping(target = "terrainsReserves", ignore = true)
    void updateEntity(UtilisateurDto utilisateurDto, @MappingTarget Utilisateur utilisateur);
}
