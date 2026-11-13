package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.CoordonneesDto;
import com.polytech.polytech.entity.Coordonnees;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoordonneesMapper {

    CoordonneesDto toDto(Coordonnees coordonnees);

    Coordonnees toEntity(CoordonneesDto coordonneesDto);
}
