package com.meli.desafiospring.exception.handler;

import com.meli.desafiospring.dto.ExceptionDTO;
import com.meli.desafiospring.exception.UnfollowException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UnfollowExceptionHandler {
    @ExceptionHandler(UnfollowException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(UnfollowException exception) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(exception.getMessage()));
    }
}
