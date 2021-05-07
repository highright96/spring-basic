package dev.highright96.exception.dto;

import lombok.Getter;

@Getter
public final class Error {

    private String field;
    private String msg;
    private String invalidValue;

    private Error() {
    }

    public static Error getErrorInstance(String field, String msg, String invalidValue) {
        Error error = new Error();
        error.field = field;
        error.msg = msg;
        error.invalidValue = invalidValue;
        return error;
    }
}
