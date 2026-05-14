package com.nexus.wishlist_service.repositories;

import com.nexus.wishlist_service.models.WishlistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistModel, Long> {
    List<WishlistModel> findByUsuarioId(Long usuarioId);
    void deleteByUsuarioIdAndJuegoId(Long usuarioId, Long juegoId);
}