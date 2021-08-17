package dev.highright96.swagger.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRes {
    @ApiModelProperty(value = "사용자 이름", example = "steve")
    private String name;

    @ApiModelProperty(value = "사용자 나이", example = "30")
    private int age;
}