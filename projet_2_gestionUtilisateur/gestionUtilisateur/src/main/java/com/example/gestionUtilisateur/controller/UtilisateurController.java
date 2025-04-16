package com.example.gestionUtilisateur.controller;

import com.example.gestionUtilisateur.model.entity.Utilisateur;
import com.example.gestionUtilisateur.service.JwtService;
import com.example.gestionUtilisateur.service.UtilisateurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Gestionutilisateur")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/addUtilisateur")
    public ResponseEntity<?> createUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        try {

            Utilisateur newUtilisateur = (Utilisateur) utilisateurService.AddUtilisateur(
                    utilisateur.getNom(),
                    utilisateur.getPassword(),
                    utilisateur.getEmail()
            );

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of("message", "Ajouté avec succès", "utilisateur", newUtilisateur));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }



    @GetMapping("/getAllUtilisateur")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.GetAllUtilisateur();
        if(jwtService!=null) {
            return ResponseEntity.ok(utilisateurs);
        }else {
            return ResponseEntity.badRequest().body(utilisateurs);
        }
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
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            Utilisateur utilisateur = (Utilisateur) authentication.getPrincipal();
            String jwtToken = jwtService.generateToken(utilisateur);

            return ResponseEntity.ok(Map.of(
                    "token", jwtToken,
                    "message", "Authentification réussie",
                    "utilisateur", utilisateur.getNom()
            ));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Email ou mot de passe incorrect"));
        }
    }
}

