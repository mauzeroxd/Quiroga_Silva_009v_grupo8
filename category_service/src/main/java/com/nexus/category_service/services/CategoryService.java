package com.nexus.category_service.services;

import com.nexus.category_service.client.AuthClient;
import com.nexus.category_service.dtos.request.CategoryRequest;
import com.nexus.category_service.dtos.response.CategoryResponse;
import com.nexus.category_service.exceptions.NotFoundException;
import com.nexus.category_service.exceptions.RemoteServiceException;
import com.nexus.category_service.models.CategoryModel;
import com.nexus.category_service.repositories.CategoryRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private AuthClient authClient;

    public CategoryResponse crear(CategoryRequest request, Long adminId) {
        try {
            // 1. Validamos la existencia y el rol del usuario mediante el cliente Feign
            var user = authClient.getUserById(adminId);
            
            // 2. Verificamos que el rol sea exactamente ADMIN
            if (user.get("rol") == null || !user.get("rol").toString().equals("ADMIN")) {
                throw new RemoteServiceException("Acceso denegado: Se requieren permisos de administrador.");
            }

            // 3. Si la validación pasa, procedemos a guardar
            CategoryModel model = new CategoryModel();
            model.setNombre(request.getNombre().toUpperCase());
            model.setDescripcion(request.getDescripcion());
            
            CategoryModel saved = repository.save(model);
            return mapToResponse(saved);

        } catch (FeignException.NotFound e) {
            throw new NotFoundException("El ID de administrador " + adminId + " no existe en el sistema.");
        } catch (FeignException e) {
            throw new RemoteServiceException("Error de comunicación con el servicio Auth-Service.");
        }
    }

    public List<CategoryResponse> listarTodas() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse obtenerPorId(Long id) {
        Objects.requireNonNull(id, "El ID de categoría es obligatorio");
        CategoryModel cat = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada con ID: " + id));
        return mapToResponse(cat);
    }

    private CategoryResponse mapToResponse(CategoryModel model) {
        return CategoryResponse.builder()
                .id(model.getId())
                .nombre(model.getNombre())
                .descripcion(model.getDescripcion())
                .build();
    }
}