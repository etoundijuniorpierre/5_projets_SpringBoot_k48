package com.example.InventaireDEproduits.repository;

import com.example.InventaireDEproduits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventaireRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findByNom(String nom);

    void deleteByNom(String nom);

    List<Produit> findByQuantiteLessThan(int seuil);
}
