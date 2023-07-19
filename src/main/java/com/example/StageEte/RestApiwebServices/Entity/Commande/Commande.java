package com.example.StageEte.RestApiwebServices.Entity.Commande;

import java.time.LocalDate;
import java.util.List;

import com.example.StageEte.RestApiwebServices.Entity.Client.Client;
import com.example.StageEte.RestApiwebServices.Entity.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PastOrPresent;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Integer id;
    @PastOrPresent
    private LocalDate commandeDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client client;
    
    @ManyToMany
    private List<Product> listProduit;
    private double prixTotal;


    public Commande() {
    }


    public Commande(Integer id, LocalDate commandeDate, Client client, List<Product> listProduit,double prixTotal) {
        this.id = id;
        this.commandeDate = commandeDate;
        this.client = client;
        this.listProduit = listProduit;
        this.prixTotal=prixTotal;
    }

    public double getPrixTotal() {
        return this.prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public List<Product> getListProduit() {
        return this.listProduit;
    }

    public void setListProduit(List<Product> listProduit) {
        this.listProduit = listProduit;
    }
   

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCommandeDate() {
        return this.commandeDate;
    }

    public void setCommandeDate(LocalDate commandeDate) {
        this.commandeDate = commandeDate;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
