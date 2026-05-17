package com.nexus.inventory_service.services;

import com.nexus.inventory_service.client.CatalogClient;
import com.nexus.inventory_service.dtos.request.InventoryRequest;
import com.nexus.inventory_service.dtos.response.CatalogResponse;
import com.nexus.inventory_service.dtos.response.InventoryResponse;
import com.nexus.inventory_service.exceptions.RemoteServiceException;
import com.nexus.inventory_service.models.InventoryModel;
import com.nexus.inventory_service.repositories.InventoryRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryService {

    @Autowired private InventoryRepository repository;
    @Autowired private CatalogClient catalogClient;

    public InventoryResponse registrarInventario(InventoryRequest request) {
        try {
            CatalogResponse juego = catalogClient.getJuegoById(request.getVideojuegoId());

            InventoryModel model = new InventoryModel();
            model.setVideojuegoId(juego.getId());
            model.setCantidad(request.getCantidad());

            InventoryModel saved = repository.save(model);

            return InventoryResponse.builder()
                    .id(saved.getId())
                    .videojuegoId(saved.getVideojuegoId())
                    .cantidad(saved.getCantidad())
                    .nombreJuego(juego.getTitulo())
                    .build();

        } catch (FeignException.NotFound e) {
            throw new RemoteServiceException("El juego ID " + request.getVideojuegoId() + " no existe en el catálogo");
        } catch (FeignException e) {
            throw new RemoteServiceException("Error de comunicación con Catalog-Service");
        }
    }
}