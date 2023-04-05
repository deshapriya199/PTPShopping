package com.san4N.PTPShoping.handler;

import com.san4N.PTPShoping.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDTO resourceNotFoundException(MethodArgumentNotValidException ex, WebRequest request) {
        return ErrorDTO.builder()
                .error(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .message(Objects.requireNonNull(ex.getDetailMessageArguments())[1].toString())
                .build();
    }

}
