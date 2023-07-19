package com.example.StageEte.RestApiwebServices.Entity.Product;

import java.util.List;

import com.example.StageEte.RestApiwebServices.Entity.Commande.Commande;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_gen_product", sequenceName = "id_gen_product",  initialValue = 21)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen_product")
    private Integer id;

    private String nomProduit;
    private String description;
    private double price;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "listProduit")
    @JsonIgnore
    private List<Commande> commande;

    public Product() {
    }

    public Product(Integer id, String nomProduit, String description, List<Commande> commande, double price) {
        this.id = id;
        this.nomProduit = nomProduit;
        this.description = description;
        this.commande = commande;
        this.price=price;
    }


    public List<Commande> getCommande() {
        return this.commande;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProduit() {
        return this.nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

}

  
