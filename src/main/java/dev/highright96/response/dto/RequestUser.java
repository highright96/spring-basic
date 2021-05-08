package dev.highright96.response.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class) //user_name 형태로 받고, 내려준다.
@JsonInclude(JsonInclude.Include.NON_NULL) //내릴때 NULL 을 내려주지 않는다.
public class RequestUser {
    private String userName;
    private Integer age;
}
