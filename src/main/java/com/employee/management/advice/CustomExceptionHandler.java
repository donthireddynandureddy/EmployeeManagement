package com.employee.management.advice;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ErrorHandlerResponseDTO> handleEntityExistsException(EntityExistsException entityNotFoundException) {

        ErrorHandlerResponseDTO errorHandlerResponseDTO = new ErrorHandlerResponseDTO();
        errorHandlerResponseDTO.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        errorHandlerResponseDTO.setError("User already present");
        errorHandlerResponseDTO.setMessage(entityNotFoundException.getMessage());
        return ResponseEntity.unprocessableEntity().body(errorHandlerResponseDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorHandlerResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {

        ErrorHandlerResponseDTO errorHandlerResponseDTO = new ErrorHandlerResponseDTO();
        errorHandlerResponseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        errorHandlerResponseDTO.setError("Constraint Violation Exception");
        errorHandlerResponseDTO.setMessage(methodArgumentNotValidException.getMessage());
        return ResponseEntity.badRequest().body(errorHandlerResponseDTO);
    }
}
