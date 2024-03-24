package org.example.project_media.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerValidationException(MethodArgumentNotValidException m, WebRequest request){
        Map<String, String> mapErrors = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach((error) -> {
            String key = ((org.springframework.validation.FieldError) error).getField(); // nome do campo
            String value = error.getDefaultMessage(); // message error

            mapErrors.put(key, value);
        });

        return new ResponseEntity<>(mapErrors, HttpStatus.BAD_REQUEST);
    }
}
