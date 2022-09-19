package com.algaworks.algalog.algalogapi.api.controller;


import com.algaworks.algalog.algalogapi.domain.model.Delivery;
import com.algaworks.algalog.algalogapi.domain.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
    private DeliveryService deliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery openRequest(@RequestBody Delivery delivery) {
        return deliveryService.openRequest(delivery);
    }


}
