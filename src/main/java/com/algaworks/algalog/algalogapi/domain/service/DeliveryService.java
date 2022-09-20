package com.algaworks.algalog.algalogapi.domain.service;

import com.algaworks.algalog.algalogapi.domain.model.Client;
import com.algaworks.algalog.algalogapi.domain.model.Delivery;
import com.algaworks.algalog.algalogapi.domain.model.DeliveryStatus;
import com.algaworks.algalog.algalogapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.OffsetDateTime;


@AllArgsConstructor
@Service
public class DeliveryService {

    private ClientService clientService;
    private DeliveryRepository deliveryRespository;

    @Transactional
    public Delivery openRequest(Delivery delivery) {
        Client client = clientService.search(delivery.getClient().getId());
        delivery.setClient(client);
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setOrderTime(OffsetDateTime.now());

        return deliveryRespository.save(delivery);
    }
}
