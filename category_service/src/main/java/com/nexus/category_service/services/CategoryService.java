package com.nexus.category_service.services;

import com.nexus.category_service.dtos.request.CategoryRequest;
import com.nexus.category_service.dtos.response.CategoryResponse;
import com.nexus.category_service.exceptions.NotFoundException;
import com.nexus.category_service.models.CategoryModel;
import com.nexus.category_service.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired private CategoryRepository repository;

    public CategoryResponse crear(CategoryRequest request) {
        CategoryModel model = new CategoryModel();
        model.setNombre(request.getNombre());
        model.setDescripcion(request.getDescripcion());
        CategoryModel saved = repository.save(model);
        return mapToResponse(saved);
    }

    public List<CategoryResponse> listarTodas() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse obtenerPorId(Long id) {
        CategoryModel cat = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoría no encontrada"));
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