package com.example.gestionUtilisateur.service;

import com.example.gestionUtilisateur.model.Utilisateur;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UtilisateurService {

    Utilisateur AddUtilisateur(String nom, String password, String email);

    List<Utilisateur> GetAllUtilisateur();

    Utilisateur GetOneUtilisateur(String nom);


    ResponseEntity<Map<String, Object>> DeleteUtilisateur(String nom);

    ResponseEntity<Map<String, Object>> UpdateUtilisateur(String nom, Utilisateur utilisateurDetails);

    String authenticate(String nom, String password);

}
