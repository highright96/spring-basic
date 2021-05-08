package dev.highright96.objectmapper;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter @ToString
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AdvancedCar {
    private String name;
    private String carNumber;

    @Builder
    public AdvancedCar(String name, String carNumber){
        this.name = name;
        this.carNumber = carNumber;
    }
}
