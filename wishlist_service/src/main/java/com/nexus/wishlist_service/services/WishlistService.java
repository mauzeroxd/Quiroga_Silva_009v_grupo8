package com.nexus.wishlist_service.services;

import com.nexus.wishlist_service.client.*;
import com.nexus.wishlist_service.dtos.request.WishlistRequest;
import com.nexus.wishlist_service.dtos.response.WishlistResponse;
import com.nexus.wishlist_service.exceptions.RemoteServiceException;
import com.nexus.wishlist_service.models.WishlistModel;
import com.nexus.wishlist_service.repositories.WishlistRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistService {

    @Autowired private WishlistRepository repository;
    @Autowired private AuthClient authClient;
    @Autowired private CatalogClient catalogClient;

    public WishlistResponse agregar(WishlistRequest request) {
        try {
            var user = authClient.getUserById(request.getUsuarioId());
            var game = catalogClient.getJuegoById(request.getJuegoId());

            WishlistModel model = new WishlistModel();
            model.setUsuarioId(request.getUsuarioId());
            model.setJuegoId(request.getJuegoId());

            WishlistModel saved = repository.save(model);

            return WishlistResponse.builder()
                    .id(saved.getId())
                    .usuario(user.get("username").toString())
                    .juego(game.get("titulo").toString())
                    .precioActual(Double.parseDouble(game.get("precio").toString()))
                    .build();
        } catch (FeignException e) {
            throw new RemoteServiceException("Error: Usuario o Juego no existen.");
        }
    }

    public List<WishlistResponse> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId).stream().map(item -> {
            var game = catalogClient.getJuegoById(item.getJuegoId());
            return WishlistResponse.builder()
                    .id(item.getId())
                    .juego(game.get("titulo").toString())
                    .precioActual(Double.parseDouble(game.get("precio").toString()))
                    .build();
        }).collect(Collectors.toList());
    }
}