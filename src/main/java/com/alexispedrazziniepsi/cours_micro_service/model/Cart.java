package com.alexispedrazziniepsi.cours_micro_service.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    // id | clientId | produits dans le panier (liste id produits)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;

    @ElementCollection
    private List<String> products = new ArrayList<>();

    // Constructeur vide pour JPA
    public Cart(){}

    // Constructeur

    public Cart(Long id, String clientId, List<String> products){
        this.id = id;
        this.clientId = clientId;
        this.products = products;
    }

    public Cart(String clientId) {
    }

    // Méthodes
    // Ajout produit au panier
    public void addProduct(String productId){
        products.add(productId);
    }

    // getters setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
