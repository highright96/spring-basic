package dev.highright96.restapi;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@JsonInclude(JsonInclude.Include.NON_NULL) //내릴때 NULL 을 내려주지 않는다.
public class RestApiRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private List<String> items;

    @Builder
    public RestApiRequest(String name, String description, List<String> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }

    // request -> Domain
    public RestApiDomain toRestApiDomain() {
        return RestApiDomain.builder()
                .name(name)
                .description(description)
                .items(items)
                .build();
    }
}

