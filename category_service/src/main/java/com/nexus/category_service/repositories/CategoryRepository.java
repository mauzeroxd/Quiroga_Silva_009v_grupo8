package com.nexus.category_service.repositories;

import com.nexus.category_service.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    Optional<CategoryModel> findByNombre(String nombre);
}