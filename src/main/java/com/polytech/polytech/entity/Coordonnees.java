package com.polytech.polytech.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coordonnees")
public class Coordonnees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant; //

    @Column(name = "geolocalisation")
    private String geolocalisation; //

    public Coordonnees() {}

    // Getters et Setters
    public Long getIdentifiant() {
        return identifiant; 
    }
    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant; 
    }

    public String getGeolocalisation() { 
        return geolocalisation; 
    }
    public void setGeolocalisation(String geolocalisation) {
        this.geolocalisation = geolocalisation; 
    }
    
}