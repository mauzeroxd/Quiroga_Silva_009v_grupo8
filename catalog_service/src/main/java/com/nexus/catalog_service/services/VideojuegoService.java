package com.nexus.catalog_service.services;
import com.nexus.catalog_service.dtos.request.VideojuegoRequest;
import com.nexus.catalog_service.dtos.response.VideojuegoResponse;
import com.nexus.catalog_service.exceptions.NotFoundException;
import com.nexus.catalog_service.models.VideojuegoModel;
import com.nexus.catalog_service.repositories.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.math.BigDecimal;

@Service
@Transactional
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository repository;

    public List<VideojuegoResponse> findAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public VideojuegoResponse findById(Long id) {
        Objects.requireNonNull(id, "El ID de videojuego es obligatorio");
        VideojuegoModel model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Videojuego no encontrado con ID: " + id));
        return mapToResponse(model);
    }

    private VideojuegoResponse mapToResponse(VideojuegoModel model) {
        return VideojuegoResponse.builder()
                .id(model.getId())
                .titulo(model.getTitulo())
                .genero(model.getGenero())
                .precio(model.getPrecio())
                .plataforma(model.getPlataforma())
                .build();
    }
    public VideojuegoResponse save(VideojuegoRequest request) {
        // 1. Creamos la entidad y pasamos los datos del DTO Request
        VideojuegoModel juego = new VideojuegoModel();
        juego.setTitulo(request.getTitulo());
        
        // Pasamos el género a mayúsculas para que calce perfecto con tu categoría "MMO" o "ACCION"
        juego.setGenero(request.getGenero().toUpperCase()); 
        juego.setPrecio(request.getPrecio() != null ? BigDecimal.valueOf(request.getPrecio()) : null);
        juego.setPlataforma(request.getPlataforma());

        // 2. Guardamos en la base de datos nexus_catalog_db
        VideojuegoModel guardado = repository.save(juego);

        // 3. Mapeamos el resultado al DTO Response (Usa Builder si lo tienes o constructor común)
        // Opción con Builder (Lombok):
        return VideojuegoResponse.builder()
                .id(guardado.getId())
                .titulo(guardado.getTitulo())
                .genero(guardado.getGenero())
                .precio(guardado.getPrecio())
                .plataforma(guardado.getPlataforma())
                .build();
    }
}
