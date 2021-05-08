package dev.highright96.objectmapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectMapperUser {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "ObjectMapperUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
