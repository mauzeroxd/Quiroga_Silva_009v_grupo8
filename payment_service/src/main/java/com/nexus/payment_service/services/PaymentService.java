package com.nexus.payment_service.services;

import com.nexus.payment_service.client.OrderClient;
import com.nexus.payment_service.dtos.request.PaymentRequest;
import com.nexus.payment_service.dtos.response.PaymentResponse;
import com.nexus.payment_service.exceptions.RemoteServiceException;
import com.nexus.payment_service.models.PaymentModel;
import com.nexus.payment_service.repositories.PaymentRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired private PaymentRepository repository;
    @Autowired private OrderClient orderClient;

    public PaymentResponse procesarPago(PaymentRequest request) {
        try {
            // Validar pedido con el microservicio de Orders
            var order = orderClient.getOrderById(request.getPedidoId());
            
            PaymentModel payment = new PaymentModel();
            payment.setPedidoId(request.getPedidoId());
            payment.setMonto(Double.parseDouble(order.get("totalPagado").toString()));
            payment.setMetodoPago(request.getMetodoPago());
            payment.setEstado("APROBADO"); // Simulación de éxito
            payment.setFechaPago(LocalDateTime.now());

            PaymentModel saved = repository.save(payment);

            return PaymentResponse.builder()
                    .pagoId(saved.getId())
                    .pedidoId(saved.getPedidoId())
                    .montoPagado(saved.getMonto())
                    .estado(saved.getEstado())
                    .fecha(saved.getFechaPago())
                    .build();

        } catch (FeignException.NotFound e) {
            throw new RemoteServiceException("No se puede pagar: El Pedido ID " + request.getPedidoId() + " no existe.");
        }
    }
}