package com.algaworks.algalog.algalogapi.api.assembler;


import com.algaworks.algalog.algalogapi.api.model.DeliveryModel;
import com.algaworks.algalog.algalogapi.api.model.RecipientModel;
import com.algaworks.algalog.algalogapi.domain.model.Delivery;
import com.algaworks.algalog.algalogapi.domain.model.Recipient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

    public DeliveryModel toModel(Delivery delivery){
        return deliveryToDeliveryModel(delivery);
    }

    public List<DeliveryModel> toCollectionModel(List<Delivery> deliveries){
        return deliveries.stream().map(this::deliveryToDeliveryModel).collect(Collectors.toList());
    }

    private DeliveryModel deliveryToDeliveryModel(Delivery delivery) {
        Recipient recipient = delivery.getRecipient();
        RecipientModel recipientModel = new RecipientModel(recipient.getName(), recipient.getStreet(), recipient.getNumber(), recipient.getComplement(), recipient.getNeighborhood());
        return new DeliveryModel(delivery.getId(), delivery.getClient().getName(), recipientModel, delivery.getTax(), delivery.getStatus(), delivery.getOrderTime(), delivery.getFinishTime());
    }
}
