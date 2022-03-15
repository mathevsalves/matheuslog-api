package com.matheus.matheuslog.domain.exception;

public class DomainException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public DomainException(String message) {
        super(message);
    }
}
