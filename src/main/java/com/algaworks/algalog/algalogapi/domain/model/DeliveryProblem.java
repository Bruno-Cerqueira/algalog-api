package com.algaworks.algalog.algalogapi.domain.model;

import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

public class DeliveryProblem {
    private Long id;

    @ManyToOne
    private Delivery delivery;
    private String description;
    private OffsetDateTime registerDate;

}
