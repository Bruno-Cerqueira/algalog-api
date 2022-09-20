package com.algaworks.algalog.algalogapi.domain.model;

import com.algaworks.algalog.algalogapi.domain.model.groups.ValidationGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
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

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroup.ClientId.class)
    @NotNull
    @ManyToOne
    private Client client;

    @Valid
    @Embedded
    private Recipient recipient;

    @NotNull
    private BigDecimal tax;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name="orderTime")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime orderTime;

    @Column(name="finishTime")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime finishTime;
}
