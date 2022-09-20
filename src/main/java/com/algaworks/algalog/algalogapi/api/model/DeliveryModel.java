package com.algaworks.algalog.algalogapi.api.model;

import com.algaworks.algalog.algalogapi.domain.model.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Getter
@Setter
public class DeliveryModel {

    private Long id;
    private String clientName;
    private RecipientModel recipient;
    private BigDecimal tax;
    private DeliveryStatus status;
    private OffsetDateTime orderTime;
    private OffsetDateTime finishTime;
}
