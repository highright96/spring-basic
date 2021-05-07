package dev.highright96.exception.advice;

import dev.highright96.exception.controller.ExceptionApiController;
import dev.highright96.exception.dto.Error;
import dev.highright96.exception.dto.ErrorResponse;
import dev.highright96.validation.controller.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestControllerAdvice(basePackageClasses = ExceptionApiController.class)
public class ExceptionApiControllerAdvice {

    /*
    ExceptionApiController 의 모든 예외를 처리하는 메소드
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> exception(Exception e) {
        System.out.println(e.getClass().getName());
        System.out.println("-----------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("-----------------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    /*
    특정 예외를 처리하는 메소드
     */

    // dtd validation 검사
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().forEach(error -> {

            FieldError fieldError = (FieldError) error;
            String errorField = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            String invalidValue = fieldError.getRejectedValue().toString();

            Error errorInstance = Error.getErrorInstance(errorField, errorMessage, invalidValue);
            errorList.add(errorInstance);
        });

        ErrorResponse errorResponse = ErrorResponse.getErrorResponse(
                errorList, HttpStatus.BAD_REQUEST.toString(), httpServletRequest.getRequestURI(), "FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 파라미터 arg validation 검사
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationException(ConstraintViolationException e, HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();

        e.getConstraintViolations().forEach(error -> {
            Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(), false);
            List<Path.Node> list = stream.collect(Collectors.toList());

            String fieldName = list.get(list.size() - 1).getName();
            String message = error.getMessage();
            String invalidValue = error.getInvalidValue().toString();

            Error errorInstance = Error.getErrorInstance(fieldName, message, invalidValue);
            errorList.add(errorInstance);
        });

        ErrorResponse errorResponse = ErrorResponse.getErrorResponse(
                errorList, HttpStatus.BAD_REQUEST.toString(), httpServletRequest.getRequestURI(), "FAIL");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    // 파라미터 arg 검사
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest httpServletRequest) {

        List<Error> errorList = new ArrayList<>();
        
        String parameterName = e.getParameterName();
        String parameterType = e.getParameterType();
        String message = e.getMessage();

        Error errorInstance = Error.getErrorInstance(parameterName, message, parameterType);
        errorList.add(errorInstance);

        ErrorResponse errorResponse = ErrorResponse.getErrorResponse(
                errorList, HttpStatus.BAD_REQUEST.toString(), httpServletRequest.getRequestURI(), "FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
