package dev.highright96.restapi;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
public class RestApiDomain {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private List<String> items;

    @Builder
    public RestApiDomain(String name, String description, List<String> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }

}
