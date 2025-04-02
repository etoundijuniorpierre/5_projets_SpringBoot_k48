package com.example.InventaireDEproduits.controller;


import com.example.InventaireDEproduits.model.Produit;
import com.example.InventaireDEproduits.service.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/inventaireDEproduits")
public class InventaireController {

    private final InventaireService inventaireService;

    @Autowired
    public InventaireController(InventaireService inventaireService) {
        this.inventaireService = inventaireService;
    }

    @PostMapping({"/addProduit"})
    public String addProduit(@RequestBody Produit produit) {
         this.inventaireService.addProduit(produit);
         return produit.getNom() + " added to the inventaire";
    }

    @GetMapping({"/getAllProduit"})
    public List<Produit> getAllProduit() {
        return this.inventaireService.getAllProduit();
    }

    @GetMapping("/getOneProduit/{nom}")
    public ResponseEntity<?> getOneProduit(@PathVariable String nom) {
        Optional<Produit> produitOptional = this.inventaireService.getOneProduit(nom);
        if (produitOptional.isPresent()) {
            return ResponseEntity.ok(produitOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteOneProduit/{nom}")
    public ResponseEntity<Map<String, Object>> deleteOneProduit(@PathVariable String nom) {
        Produit deletedProduit = inventaireService.deleteOneProduit(nom);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Produit supprimé avec succès !");
        response.put("deletedProduit", deletedProduit.getNom());
        return ResponseEntity.ok(response);
    }

    @PutMapping({"/updateOneProduit/{nom}"})
    public ResponseEntity<Produit> updateOneProduit(@PathVariable String nom, @RequestBody Produit upProduit) {
        Produit updatedProduit = this.inventaireService.updateOneProduit(nom, upProduit);
        return ResponseEntity.ok(updatedProduit);
    }
    
    @GetMapping("/getStocksProduit")
    public ResponseEntity<Map<String, Object>> verifierStocksBas() {
        List<Produit> produits = inventaireService.verifierStocksBas();
        Map<String, Object> reponse = new HashMap<>();
        reponse.put("message", "Alert les produits suivants sont en deçà du seuil");
        reponse.put("produits", produits);
        return ResponseEntity.ok(reponse);
    }


}

