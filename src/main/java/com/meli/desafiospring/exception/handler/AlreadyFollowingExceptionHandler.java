package com.meli.desafiospring.exception.handler;

import com.meli.desafiospring.dto.ExceptionDTO;
import com.meli.desafiospring.exception.AlreadyFollowingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AlreadyFollowingExceptionHandler {

    @ExceptionHandler(AlreadyFollowingException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(AlreadyFollowingException exception) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(exception.getMessage()));
    }
}
