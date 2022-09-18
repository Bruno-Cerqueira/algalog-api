package com.algaworks.algalog.algalogapi.api.exceptionhandler;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Error error = new Error();
        List<Error.Field> fields = new ArrayList<>();

        for(ObjectError validationError : ex.getBindingResult().getAllErrors()){
            String name = ((FieldError) validationError).getField();
            String message = messageSource.getMessage(validationError, LocaleContextHolder.getLocale());

            fields.add(new Error.Field(name, message));
        }
        error.setStatus(status.value());
        error.setLocalDateTime(LocalDateTime.now());
        error.setTitle("Um ou mais campos estão inválidos");
        error.setFields(fields);
        return handleExceptionInternal(ex, error, headers, status, request);
    }
}
