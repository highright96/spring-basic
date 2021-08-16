package dev.highright96.validation.exception;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorResponse {

    private int status;

    private String message;

    private String code;

    private List<FieldError> errors;

    private ErrorResponse(int status, String message, String code, List<FieldError> errors) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.errors = errors;
    }

    public static ErrorResponse of(int status, String message, String code,
        BindingResult bindingResult) {
        return new ErrorResponse(status, message, code, FieldError.of(bindingResult));
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FieldError {

        private String field;

        private String value;

        private String reason;


        public static List<FieldError> of(BindingResult bindingResult) {
            List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                .map(error -> new FieldError(
                    error.getField(),
                    error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                    error.getDefaultMessage()))
                .collect(Collectors.toList());
        }
    }
}
