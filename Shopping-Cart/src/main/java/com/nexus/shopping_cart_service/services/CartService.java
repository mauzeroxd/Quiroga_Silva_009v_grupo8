package com.nexus.shopping_cart_service.services;

import com.nexus.shopping_cart_service.client.*;
import com.nexus.shopping_cart_service.dtos.request.CartRequest;
import com.nexus.shopping_cart_service.dtos.response.CartResponse;
import com.nexus.shopping_cart_service.exceptions.RemoteServiceException;
import com.nexus.shopping_cart_service.models.CartModel;
import com.nexus.shopping_cart_service.repositories.CartRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired private CartRepository repository;
    @Autowired private AuthClient authClient;
    @Autowired private CatalogClient catalogClient;

    public CartResponse agregarAlCarrito(CartRequest request) {
        try {
            var user = authClient.getUserById(request.getUsuarioId());
            var game = catalogClient.getJuegoById(request.getJuegoId());

            CartModel cart = new CartModel();
            cart.setUsuarioId(request.getUsuarioId());
            cart.setJuegoId(request.getJuegoId());
            cart.setCantidad(request.getCantidad());
            
            CartModel saved = repository.save(cart);

            Double precio = (Double) game.get("precio");
            
            return CartResponse.builder()
                    .id(saved.getId())
                    .nombreUsuario(user.get("username").toString())
                    .nombreJuego(game.get("titulo").toString())
                    .cantidad(saved.getCantidad())
                    .subtotal(precio * saved.getCantidad())
                    .build();
        } catch (FeignException e) {
            throw new RemoteServiceException("Usuario o Juego no encontrados en el sistema");
        }
    }
}