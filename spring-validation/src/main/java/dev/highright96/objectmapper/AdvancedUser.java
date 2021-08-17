package dev.highright96.objectmapper;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class AdvancedUser {
    private String name;
    private Integer age;
    private List<AdvancedCar> cars;

    @Builder
    public AdvancedUser(String name, Integer age, List<AdvancedCar> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }
}
