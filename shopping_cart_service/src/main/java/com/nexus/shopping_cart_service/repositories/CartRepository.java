package com.nexus.shopping_cart_service.repositories;

import com.nexus.shopping_cart_service.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartModel, Long> {
    List<CartModel> findByUsuarioId(Long usuarioId);
}