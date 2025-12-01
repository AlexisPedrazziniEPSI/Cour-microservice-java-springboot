package com.alexispedrazziniepsi.cours_micro_service.service;

import com.alexispedrazziniepsi.cours_micro_service.model.Cart;
import com.alexispedrazziniepsi.cours_micro_service.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    // Constructeur
    private final CartRepository repository;

    public CartService(CartRepository cartRepository){
        this.repository = cartRepository;
    }

    //Crée un panier pour un client
    public Cart createCart(String clientId){
        Cart cart = new Cart(clientId);
        return repository.save(cart);
    }

    // Ajouter un produit a un panier existant
    public Cart addProduct(Long cartId, String productId) {
        Cart cart = repository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Panier introuvable"));
        cart.addProduct(productId);
        return repository.save(cart);
    }

    // récupérer un panier existant
    public Cart getCart(Long cartId) {
        return repository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Panier introuvable"));
    }

    // méthode pour ajouter un produit
}
