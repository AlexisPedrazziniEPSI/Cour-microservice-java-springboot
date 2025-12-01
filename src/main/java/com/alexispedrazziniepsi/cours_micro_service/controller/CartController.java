package com.alexispedrazziniepsi.cours_micro_service.controller;

import com.alexispedrazziniepsi.cours_micro_service.model.Cart;
import com.alexispedrazziniepsi.cours_micro_service.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    // Créer un panier pour un client
    @PostMapping("/{clientId}")
    public Cart createCart(@PathVariable String clientId) {
        return service.createCart(clientId);
    }

    // Ajouter un produit à un panier
    @PostMapping("/{cartId}/products/{productId}")
    public Cart addProduct(@PathVariable Long cartId, @PathVariable String productId) {
        return service.addProduct(cartId, productId);
    }

    // Récupérer un panier
    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable Long cartId) {
        return service.getCart(cartId);
    }
}
