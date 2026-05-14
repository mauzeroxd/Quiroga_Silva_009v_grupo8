package com.nexus.review_service.repositories;

import com.nexus.review_service.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {
    List<ReviewModel> findByJuegoId(Long juegoId);
}