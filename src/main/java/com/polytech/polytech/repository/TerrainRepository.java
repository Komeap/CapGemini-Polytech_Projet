package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Terrain;

import javax.swing.Spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
//Grâce à JpaRepository, Spring fournit automatiquement les méthodes CRUD
}