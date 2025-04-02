package com.example.gestionUtilisateur.service;

import com.example.gestionUtilisateur.model.Utilisateur;
import com.example.gestionUtilisateur.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Utilisateur AddUtilisateur(String nom, String password, String email) {
        if (utilisateurRepository.findByNom(nom) != null) {
            throw new RuntimeException("Un utilisateur avec ce nom existe déjà");
        }

        String encodedPassword = passwordEncoder.encode(password);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPassword(encodedPassword);
        utilisateur.setEmail(email);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> GetAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur GetOneUtilisateur(String nom) {
        return utilisateurRepository.findByNom(nom);
    }

    @Override
    public ResponseEntity<Map<String, Object>> DeleteUtilisateur(String nom) {
        Utilisateur utilisateur = utilisateurRepository.findByNom(nom);
        if (utilisateur==null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }

        utilisateurRepository.delete(utilisateur);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "supprimé avec succès");
        response.put("utilisateur : ", utilisateur.getNom());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Map<String, Object>> UpdateUtilisateur(String nom, Utilisateur utilisateurDetails) {

        Utilisateur utilisateurExist = utilisateurRepository.findByNom(nom);

        if (utilisateurExist == null) {
            return ResponseEntity.notFound().build();
        }

        if (utilisateurDetails.getNom() != null) {
            utilisateurExist.setNom(utilisateurDetails.getNom());
        }

        if (utilisateurDetails.getEmail() != null) {
            utilisateurExist.setEmail(utilisateurDetails.getEmail());
        }

        if (utilisateurDetails.getPassword() != null && !utilisateurDetails.getPassword().isEmpty()) {
            utilisateurExist.setPassword(passwordEncoder.encode(utilisateurDetails.getPassword()));
        }

        Utilisateur updatedUser = utilisateurRepository.save(utilisateurExist);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Utilisateur mis à jour avec succès");
        response.put("id", updatedUser.getId());
        response.put("nom", updatedUser.getNom());
        response.put("email", updatedUser.getEmail());

        return ResponseEntity.ok(response);
    }


    @Override
    public String authenticate(String nom, String password) {
        utilisateurRepository.findByNom(nom);
        return ("trouvé");
    }
}