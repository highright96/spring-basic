package dev.highright96.exception.dto;

import lombok.Getter;

@Getter
public enum ErrorCode {

    /*
    기본적인 에러
     */
    INTERNAL_SERVER_ERROR(500, "C_001", "서버에 문제가 생겼습니다."),
    METHOD_NOT_ALLOWED(405, "C_002", "해당 API는 사용할 수 없습니다."),
    INVALID_INPUT_VALUE(400, "C_003", "적절하지 않은 요청 값입니다."),
    INVALID_TYPE_VALUE(400, "C_004", "요청 값의 타입이 잘못되었습니다."),
    ENTITY_NOT_FOUND(400, "C_005", "지정한 엔티티를 찾을 수 없습니다."),

    /*
    인증 관련 에러
    */
    AUTH_ERROR(400, "AU_001", "인증 관련 오류가 발생했습니다."),
    DUPLICATED_EMAIL(400, "AU_002", "이미 존재하는 E-mail입니다."),
    INVALID_LOGIN(400, "AU_004", "잘못된 아이디 또는 패스워드입니다."),

    /*
    비즈니스 로직 에러
     */
    FARM_NOT_FOUND(400, "F_OO1", "농장을 찾을 수 없습니다");
    
    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
