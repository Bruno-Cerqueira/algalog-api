package com.algaworks.algalog.algalogapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
public class RecipientModel {

    private String name;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
}
