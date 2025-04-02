package com.example.InventaireDEproduits.service;

import com.example.InventaireDEproduits.model.Produit;
import com.example.InventaireDEproduits.repository.InventaireRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventaireServiceImpl implements InventaireService{
    private final InventaireRepository inventaireRepository;

    @Autowired
    public InventaireServiceImpl(InventaireRepository inventaireRepository){
        this.inventaireRepository = inventaireRepository;
    }

    @Override
    public Produit addProduit(Produit produit) {
        return this.inventaireRepository.save(produit);
    }

    @Override
    public List<Produit> getAllProduit() {
        return this.inventaireRepository.findAll();
    }

    @Override
    public Optional<Produit> getOneProduit(String nom) {
        return this.inventaireRepository.findByNom(nom);
    }

    @Override
    @Transactional
    public Produit deleteOneProduit(String nom) {
        Produit produits = inventaireRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        inventaireRepository.deleteByNom(nom);
        return produits;
    }

    @Override
    public Produit updateOneProduit(String nom, Produit produit) {
        Produit produitExisting = (Produit)this.inventaireRepository.findByNom(nom).orElseThrow(()-> new RuntimeException("produit not found"));
        produitExisting.setNom(produit.getNom());
        produitExisting.setPrix(produit.getPrix());
        produitExisting.setQuantite(produit.getQuantite());
        return (Produit)this.inventaireRepository.save(produitExisting);
    }

    @Override
    public List<Produit> verifierStocksBas() {
        return this.inventaireRepository.findByQuantiteLessThan(10);
    }

}
