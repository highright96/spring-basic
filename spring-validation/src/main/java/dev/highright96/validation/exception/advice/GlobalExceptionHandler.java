package dev.highright96.validation.exception.advice;

import dev.highright96.validation.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = ErrorResponse.of(403, "field error", "field",
            e.getBindingResult());
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }
}
