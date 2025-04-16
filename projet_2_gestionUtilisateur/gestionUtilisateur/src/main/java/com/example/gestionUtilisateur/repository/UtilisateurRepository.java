package com.example.gestionUtilisateur.repository;

import com.example.gestionUtilisateur.model.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findById(Long id);

    Utilisateur findByNom(String nom);

    Optional<Utilisateur> findByEmail(String email);
}
