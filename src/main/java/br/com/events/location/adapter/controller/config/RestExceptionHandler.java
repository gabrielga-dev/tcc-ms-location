package br.com.events.location.adapter.controller.config;

import br.com.events.location.adapter.exception.BusinessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

/**
 * This class handle every exception mapped that is thrown onthis microservice
 *
 * @author Gabriel Guimarães de Almeida
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<Object> handleException(BusinessException ex, WebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return ResponseEntity.status(ex.getHttpStatusCode()).headers(responseHeaders).body(ex.getOnlyBody());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleException(MethodArgumentNotValidException ex, WebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        var errorMessages = String.format(Objects.requireNonNull(ex.getAllErrors().get(0).getDefaultMessage()));
        var toReturn = BusinessException.BusinessExceptionBody.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .message("Campo(s) inválido(s)!")
            .description(errorMessages)
            .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(responseHeaders).body(toReturn);
    }
}
