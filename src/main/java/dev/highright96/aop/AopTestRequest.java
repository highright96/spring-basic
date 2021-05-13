package dev.highright96.aop;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AopTestRequest {

    private String id;
    private String pwd;
    private String email;

    @Builder
    public AopTestRequest(String id, String pwd, String email) {
        this.id = id;
        this.pwd = pwd;
        this.email = email;
    }
}
