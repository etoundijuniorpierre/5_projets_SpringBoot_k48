package com.example.InventaireDEproduits.service;

import com.example.InventaireDEproduits.model.Produit;

import java.util.List;
import java.util.Optional;

public interface InventaireService {
    Produit addProduit(Produit produit);

    List<Produit> getAllProduit();

    Optional<Produit> getOneProduit(String nom);

    Produit deleteOneProduit(String nom);

    Produit updateOneProduit(String nom, Produit produit);

    List<Produit> verifierStocksBas();

}
