package com.polytech.polytech.dto;

public class TerrainDto {

    private Long identifiant;
    private Integer capacite;
    private String nom;
    private CoordonneesDto coordonnees;

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public CoordonneesDto getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(CoordonneesDto coordonnees) {
        this.coordonnees = coordonnees;
    }
}
