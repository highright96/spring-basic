package dev.highright96.exception.advice;

import dev.highright96.exception.dto.ErrorCode;
import dev.highright96.exception.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
//@RestControllerAdvice(basePackageClasses = ExceptionApiController.class) /* 특정 클래스로 제한 */
public class GlobalExceptionHandler {

    /*
    모든 예외를 처리하는 메소드
    */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> HandleServerException(Exception e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }

    /*
    특정 예외를 처리하는 메소드
    */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> HandleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
    }
}
