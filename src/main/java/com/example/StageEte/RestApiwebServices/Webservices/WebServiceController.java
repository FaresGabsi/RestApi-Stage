package com.example.StageEte.RestApiwebServices.Webservices;


import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.StageEte.RestApiwebServices.Entity.Client.Client;
import com.example.StageEte.RestApiwebServices.Entity.Client.ClientRepository;
import com.example.StageEte.RestApiwebServices.Entity.Commande.Commande;
import com.example.StageEte.RestApiwebServices.Entity.Commande.CommandeRepository;
import com.example.StageEte.RestApiwebServices.Entity.Product.Product;
import com.example.StageEte.RestApiwebServices.Entity.Product.ProductRepository;
import com.example.StageEte.RestApiwebServices.Exception.IdNotFoundException;

import jakarta.validation.Valid; 

@RestController
public class WebServiceController {

private ClientRepository clientRepository;
private CommandeRepository commandeRepository;
private ProductRepository productRepository;



    public WebServiceController(ClientRepository clientRepository, CommandeRepository commandeRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.commandeRepository = commandeRepository;
        this.productRepository = productRepository;
    }
    
    // Permet de lister tous les clients
    @GetMapping("/clients")
    public List<Client> retrieveAllClient(){
        return clientRepository.findAll();
    }

// Permet de créer un client depuis un formulaire (Webservice 1 et 2)
    @PostMapping("/clients")
    public ResponseEntity<Client> createUser(@Valid @RequestBody Client client) {
        Client savedClient = clientRepository.save(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClient.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Permet de récupérer un client par son identifiant
    @GetMapping("/clients/{id}")
    public Client retrieveClient(@PathVariable int id){
       return clientRepository.findById(id)
        .orElseThrow(() -> new IdNotFoundException(id));  
    }
        
    // Permet de récupérer les commandes d'un client par son identifiant
    @GetMapping("/clients/{id}/commandes")
    private List<Commande> retrieveCommandesForClient(@PathVariable int id){
        List<Commande> commandes=clientRepository.findById(id).get().getListCommande();
        return commandes;
    }

    // Permet de créer une commande pour un client donné
    @PostMapping("clients/{id}/commandes")
    public ResponseEntity<Commande> createCommande(@PathVariable int id,@Valid @RequestBody CommandeRequest commande) {
        Client client=clientRepository.getReferenceById(id);
        if (client == null) {
            throw new IdNotFoundException(id);
        }
        List<Integer> productIds = commande.productIds();

    // Valider les identifiants des produits et récupérer les produits correspondants
    List<Product> products = new ArrayList<>();
    double prixTotal=0;
    for (Integer productId : productIds) {
        Product product = productRepository.getReferenceById(productId);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }
        products.add(product);
        prixTotal+=product.getPrice();
    }
    Commande cmd=new Commande();
    cmd.setClient(client);
    cmd.setListProduit(products);
    cmd.setCommandeDate(LocalDate.now());
    cmd.setPrixTotal(prixTotal);
    Commande savedCommande=commandeRepository.save(cmd);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCommande.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Permet de récupérer une commande spécifique d'un client par son identifiant et l'identifiant de la commande
    @GetMapping("/clients/{id}/commandes/{id_cmd}")
    private Commande retrieveCommandesForClient(@PathVariable int id,@PathVariable int id_cmd){
       List<Commande> listcommandes=clientRepository.findById(id).get().getListCommande();
       Commande commandes = listcommandes.get(id_cmd);
        return commandes;
    }

    // Permet de lister tous les produits
    @GetMapping("/produits")
    public List<Product> retrieveAllProducts(){
        return productRepository.findAll();
    }

    // Permet de créer un produit
    @PostMapping("/produits")
    public ResponseEntity<Product> createUser(@Valid @RequestBody Product produit) {
        Product savedProduct = productRepository.save(produit);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // Permet de récupérer un produit par son identifiant
    @GetMapping("/produits/{id}")
    public Optional<Product> retrieveProduct(@PathVariable int id){
        Optional<Product> produit=productRepository.findById(id);
        return produit;
    }




/**
 * Ligne_Commande
 */
public record CommandeRequest(List<Integer> productIds) {}
    
}

