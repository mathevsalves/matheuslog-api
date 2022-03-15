package com.matheus.matheuslog.api.exceptionhandler;

import com.matheus.matheuslog.domain.exception.DomainException;
import com.matheus.matheuslog.domain.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Error error = new Error();
        List<Error.Field> fields = new ArrayList<>();

        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) objectError).getField();
            String message = messageSource.getMessage(objectError, Locale.US);

            fields.add(new Error.Field(name, message));
        }

        error.setStatus(status.value());
        error.setDateTime(OffsetDateTime.now());
        error.setTitle("One or more fields isn't valid. Fill correctly and try again.");
        error.setFields(fields);

        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        Error error = new Error();

        error.setStatus(status.value());
        error.setDateTime(OffsetDateTime.now());
        error.setTitle(ex.getMessage());


        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleDomain(DomainException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Error error = new Error();

        error.setStatus(status.value());
        error.setDateTime(OffsetDateTime.now());
        error.setTitle(ex.getMessage());


        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }
}
