package dev.highright96.validation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class User {

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

    @Email
    private String email;

    @YearMonth
    private String reqYearMonth; // yyyyMMdd

    @Valid // 특정 클래스를 검사하고 싶으면 @Valid 를 꼭 붙여줘야한다. Car 안에도 validation 을 하고 있다.
    private List<Car> cars;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                ", cars=" + cars +
                '}';
    }
}
