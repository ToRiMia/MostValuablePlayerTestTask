package com.example.mvp_test.ex.handler;

import com.example.mvp_test.ex.MVPException;
import com.example.mvp_test.ex.ParsingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class MainExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ParsingException.class)
    public static ResponseEntity<ExceptionResponse> handle(ParsingException exception) {
        log.error(exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
                exception.getLocalizedMessage()));
    }

    @ExceptionHandler(MVPException.class)
    public static ResponseEntity<ExceptionResponse> handle(MVPException exception) {
        log.error(exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                exception.getLocalizedMessage()));
    }
}
