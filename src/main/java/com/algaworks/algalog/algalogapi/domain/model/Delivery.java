package com.algaworks.algalog.algalogapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    private Recipient recipient;

    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;


    private LocalDateTime orderTime;
    private LocalDateTime finishTime;
}
