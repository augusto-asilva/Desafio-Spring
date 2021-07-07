package com.meli.desafiospring.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class UnfollowException extends DataIntegrityViolationException {
    public UnfollowException(String msg) {
        super(msg);
    }
}
