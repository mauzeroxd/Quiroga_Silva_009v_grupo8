package com.nexus.review_service.services;

import com.nexus.review_service.client.*;
import com.nexus.review_service.dtos.request.ReviewRequest;
import com.nexus.review_service.dtos.response.ReviewResponse;
import com.nexus.review_service.exceptions.RemoteServiceException;
import com.nexus.review_service.models.ReviewModel;
import com.nexus.review_service.repositories.ReviewRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired private ReviewRepository repository;
    @Autowired private AuthClient authClient;
    @Autowired private CatalogClient catalogClient;

    public ReviewResponse publicarReseña(ReviewRequest request) {
        try {
            var user = authClient.getUserById(request.getUsuarioId());
            var game = catalogClient.getJuegoById(request.getJuegoId());

            ReviewModel model = new ReviewModel();
            model.setUsuarioId(request.getUsuarioId());
            model.setJuegoId(request.getJuegoId());
            model.setCalificacion(request.getCalificacion());
            model.setComentario(request.getComentario());

            ReviewModel saved = repository.save(model);

            return ReviewResponse.builder()
                    .id(saved.getId())
                    .usuario(user.get("username").toString())
                    .juego(game.get("titulo").toString())
                    .estrellas(saved.getCalificacion())
                    .reseña(saved.getComentario())
                    .build();
        } catch (FeignException e) {
            throw new RemoteServiceException("No se pudo publicar la reseña: Usuario o Videojuego inválido.");
        }
    }
}