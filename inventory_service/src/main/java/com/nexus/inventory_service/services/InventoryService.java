package com.nexus.inventory_service.services;

import com.nexus.inventory_service.client.CatalogClient;
import com.nexus.inventory_service.dtos.request.InventoryRequest;
import com.nexus.inventory_service.dtos.response.CatalogResponse;
import com.nexus.inventory_service.dtos.response.InventoryResponse;
import com.nexus.inventory_service.exceptions.RemoteServiceException;
import com.nexus.inventory_service.models.StockKeyModel;
import com.nexus.inventory_service.repositories.StockKeyRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InventoryService {

    @Autowired private StockKeyRepository repository;
    @Autowired private CatalogClient catalogClient;

    public InventoryResponse registrarKey(InventoryRequest request) {
        try {
            // 1. Validación Cruzada: Consultar si el juego existe en Catalog [cite: 29]
            CatalogResponse juego = catalogClient.getJuegoById(request.getJuegoId());

            // 2. Persistencia en la BD propia 
            StockKeyModel model = new StockKeyModel();
            model.setJuegoId(juego.getId());
            model.setCodigoKey(request.getCodigoKey());
            model.setVendido(0);
            
            StockKeyModel saved = repository.save(model);

            return InventoryResponse.builder()
                    .id(saved.getId())
                    .codigoKey(saved.getCodigoKey())
                    .vendido(saved.getVendido())
                    .nombreJuego(juego.getTitulo())
                    .build();

        } catch (FeignException.NotFound e) {
            throw new RemoteServiceException("El juego ID " + request.getJuegoId() + " no existe en el catálogo");
        } catch (FeignException e) {
            throw new RemoteServiceException("Error de comunicación con Catalog-Service");
        }
    }
}