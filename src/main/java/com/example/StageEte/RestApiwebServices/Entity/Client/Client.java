package com.example.StageEte.RestApiwebServices.Entity.Client;

import java.time.LocalDate;
import java.util.List;

import com.example.StageEte.RestApiwebServices.Entity.Commande.Commande;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "id_gen",  initialValue = 4)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
    private Integer id;
    @Size(min =3 )
    private String name;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Commande> listCommande;
    @Past
    private LocalDate birthDate;

    public Client(int id, String name, List<Commande> listCommande, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.listCommande = listCommande;
        this.birthDate = birthDate;
    }

    public Client() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Commande> getListCommande() {
        return this.listCommande;
    }

    public void setListCommande(List<Commande> listCommande) {
        this.listCommande = listCommande;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


}
