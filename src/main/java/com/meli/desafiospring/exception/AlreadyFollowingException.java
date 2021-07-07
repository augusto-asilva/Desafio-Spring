package com.meli.desafiospring.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class AlreadyFollowingException extends DataIntegrityViolationException {

    public AlreadyFollowingException(String msg) {
        super(msg);
    }
}
