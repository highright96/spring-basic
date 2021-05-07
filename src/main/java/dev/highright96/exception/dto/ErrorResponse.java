package dev.highright96.exception.dto;

import lombok.Getter;

import java.util.List;

@Getter
public final class ErrorResponse {

    String statusCode;
    String requestUrl;
    String resultCode;
    List<Error> errorList;

    private ErrorResponse() {
    }

    public static ErrorResponse getErrorResponse(List<Error> errorList, String statusCode, String requestUrl, String resultCode) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.errorList = errorList;
        errorResponse.statusCode = statusCode;
        errorResponse.requestUrl = requestUrl;
        errorResponse.resultCode = resultCode;
        return errorResponse;
    }
}
