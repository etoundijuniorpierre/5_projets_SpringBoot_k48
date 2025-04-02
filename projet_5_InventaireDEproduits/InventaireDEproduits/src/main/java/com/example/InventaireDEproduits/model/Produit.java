package com.example.InventaireDEproduits.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table (
        name = "produit"
)
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique=true)
    private String nom;

    @NotNull
    @Column
    private float prix;

    @NotNull
    @Column
    private Long quantite;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
    public Float getPrix() {
        return prix;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
    public Long getQuantite() {
        return quantite;
    }

}
