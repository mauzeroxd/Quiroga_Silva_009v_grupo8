package com.nexus.order_service.services;

import com.nexus.order_service.client.AuthClient;
import com.nexus.order_service.client.CatalogClient;
import com.nexus.order_service.dtos.request.OrderRequest;
import com.nexus.order_service.dtos.response.OrderResponse;
import com.nexus.order_service.exceptions.RemoteServiceException;
import com.nexus.order_service.models.OrderModel;
import com.nexus.order_service.repositories.OrderRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepository;
    @Autowired private AuthClient authClient;
    @Autowired private CatalogClient catalogClient;

    public OrderResponse procesarPedido(OrderRequest request) {
        try {
            // Validar Usuario
            var user = authClient.getUserById(request.getUsuarioId());
            // Validar Juego y obtener precio
            var game = catalogClient.getJuegoById(request.getJuegoId());

            OrderModel order = new OrderModel();
            order.setUsuarioId(request.getUsuarioId());
            order.setJuegoId(request.getJuegoId());
            order.setFechaPedido(LocalDateTime.now());
            order.setTotal(Double.parseDouble(game.get("precio").toString()));
            order.setEstado("COMPLETADO");

            OrderModel saved = orderRepository.save(order);

            return OrderResponse.builder()
                    .id(saved.getId())
                    .cliente(user.get("username").toString())
                    .juego(game.get("titulo").toString())
                    .totalPagado(saved.getTotal())
                    .fecha(saved.getFechaPedido())
                    .estado(saved.getEstado())
                    .build();

        } catch (FeignException.NotFound e) {
            throw new RemoteServiceException("No se pudo completar el pedido: Usuario o Juego no existen.");
        } catch (Exception e) {
            throw new RemoteServiceException("Error interno al comunicarse con los servicios de Nexus.");
        }
    }
}