package com.example.gestionUtilisateur.service;

import com.example.gestionUtilisateur.model.entity.Utilisateur;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UtilisateurService {

    Object AddUtilisateur(String nom, String password, String email);

    List<Utilisateur> GetAllUtilisateur();

    Utilisateur GetOneUtilisateur(String nom);


    ResponseEntity<Map<String, Object>> DeleteUtilisateur(String nom);

    ResponseEntity<Map<String, Object>> UpdateUtilisateur(String nom, Utilisateur utilisateurDetails);




}
