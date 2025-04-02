package com.example.gestionUtilisateur.controller;

import com.example.gestionUtilisateur.model.Utilisateur;
import com.example.gestionUtilisateur.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Gestionutilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;

    // Injection par constructeur (recommandé au lieu de @Autowired)
    public UtilisateurController(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
        this.utilisateurService = utilisateurService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/addUtilisateur")
    public ResponseEntity<?> createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        try {
            if (utilisateur.getNom() == null || utilisateur.getPassword() == null || utilisateur.getEmail() == null) {
                return ResponseEntity.badRequest().body(Map.of("message", "Renseigner toutes les informations"));
            }
            Utilisateur newUtilisateur = utilisateurService.AddUtilisateur(
                    utilisateur.getNom(),
                    utilisateur.getPassword(),
                    utilisateur.getEmail()

            );
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(newUtilisateur, "Ajouté avec succès"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getAllUtilisateur")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.GetAllUtilisateur();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/getOneUtilisatuer/{nom}")
    public ResponseEntity<?> getUtilisateurByNom(@PathVariable String nom) {
        Utilisateur utilisateur = utilisateurService.GetOneUtilisateur(nom);
        if (utilisateur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(utilisateur);
    }

    @PutMapping("/updateUtilisateur/{nom}")
    public ResponseEntity<Map<String, Object>> updateUtilisateur(
            @PathVariable String nom,
            @Valid @RequestBody Utilisateur utilisateur) {
        try {
            return utilisateurService.UpdateUtilisateur(nom, utilisateur);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteOneUtilisateur/{nom}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable String nom) {
        try {
            return utilisateurService.DeleteUtilisateur(nom);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> loginRequest) {
        String nom = loginRequest.get("nom");
        String password = loginRequest.get("password");

        if (nom == null || password == null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Nom et mot de passe requis"));
        }

        try {
            Utilisateur utilisateur = utilisateurService.GetOneUtilisateur(nom);
            if (utilisateur == null || !passwordEncoder.matches(password, utilisateur.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("message", "Nom ou mot de passe incorrect"));
            }

            return ResponseEntity.ok(Map.of("message", "Authentification réussie", "utilisateur", utilisateur.getNom()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erreur lors de l'authentification"));
        }
    }
}