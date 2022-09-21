package com.algaworks.algalog.algalogapi.api.controller;


import com.algaworks.algalog.algalogapi.api.assembler.DeliveryAssembler;
import com.algaworks.algalog.algalogapi.api.model.DeliveryModel;
import com.algaworks.algalog.algalogapi.domain.model.Delivery;
import com.algaworks.algalog.algalogapi.domain.repository.DeliveryRepository;
import com.algaworks.algalog.algalogapi.domain.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private DeliveryService deliveryService;
    private DeliveryRepository deliveryRepository;
    private DeliveryAssembler deliveryAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery openRequest(@Valid @RequestBody Delivery delivery) {
        return deliveryService.openRequest(delivery);
    }

    @GetMapping
    public List<DeliveryModel> list() {
        return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryModel> find(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }
}
