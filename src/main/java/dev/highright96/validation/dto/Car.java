package dev.highright96.validation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Car {

    @NotBlank
    private String name;

    @NotBlank
    private String carNumber;

    @NotBlank
    private String type;

}
