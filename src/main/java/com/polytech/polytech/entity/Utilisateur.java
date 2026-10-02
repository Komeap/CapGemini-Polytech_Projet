package com.polytech.polytech.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column (name = "Identifiant", nullable = false)
    private long Identifiant;

    @Column (name = "Nom", nullable = false)
    private String Nom;

    @Column (name = "Prenom", nullable = false)
    private String Prenom;

    @Column (name = "Email")
    private String Email;
    
    // Relation Many-to-Many avec Terrain (Réserve)
    @ManyToMany
    @JoinTable(
        name = "reserve",
        joinColumns = @JoinColumn(name = "utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name = "terrain_id")
    )

    private List<Terrain> terrainsReserves;

    public Utilisateur() {}

    // Getters et Setters
    public Long getIdentifiant() { return Identifiant; }
    public void setIdentifiant(Long identifiant) { this.Identifiant = identifiant; }

    public String getNom() { return Nom; }
    public void setNom(String nom) { this.Nom = nom; }

    public String getPrenom() { return Prenom; }
    public void setPrenom(String prenom) { this.Prenom = prenom; }

    public String getEmail() { return Email; }
    public void setEmail(String email) { this.Email = email; }

    public List<Terrain> getTerrainsReserves() { return terrainsReserves; }
    public void setTerrainsReserves(List<Terrain> terrainsReserves) { this.terrainsReserves = terrainsReserves; }
}
