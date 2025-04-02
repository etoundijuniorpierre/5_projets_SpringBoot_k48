package com.example.gestionUtilisateur.repository;

import com.example.gestionUtilisateur.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findById(Long id);

    Utilisateur findByNom(String nom);
}
