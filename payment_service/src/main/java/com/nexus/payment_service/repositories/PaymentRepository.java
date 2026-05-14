package com.nexus.payment_service.repositories;

import com.nexus.payment_service.models.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}