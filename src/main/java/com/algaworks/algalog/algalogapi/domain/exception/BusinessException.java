package com.algaworks.algalog.algalogapi.domain.exception;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public BusinessException(String message) {
        super(message);
    }
}
