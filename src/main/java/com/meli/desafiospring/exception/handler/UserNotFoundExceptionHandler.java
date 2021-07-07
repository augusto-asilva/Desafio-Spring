package com.meli.desafiospring.exception.handler;

import com.meli.desafiospring.dto.ExceptionDTO;
import com.meli.desafiospring.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserNotFoundExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(UserNotFoundException exception) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(exception.getMessage()));
    }
}
