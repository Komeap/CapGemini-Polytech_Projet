package com.polytech.polytech.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "terrain")
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant;

    @Column(name = "capacite")
    private Integer capacite;

    @Column(name = "nom")
    private String nom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordonnees_id", referencedColumnName = "identifiant")
    private Coordonnees coordonnees;

    @ManyToMany(mappedBy = "terrainsReserves")
    private List<Utilisateur> utilisateurs;

    public Terrain() {}

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

    public Coordonnees getCoordonnees() { 
        return coordonnees; 
    }
    public void setCoordonnees(Coordonnees coordonnees) { 
        this.coordonnees = coordonnees; 
    }
    
    public List<Utilisateur> getUtilisateurs() { 
        return utilisateurs; 
    }
    public void setUtilisateurs(List<Utilisateur> utilisateurs) { 
        this.utilisateurs = utilisateurs; 
    }

}