package dev.highright96.restapi;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestApiResponse {

    private String name;
    private String description;
    private List<String> items;

    @Builder
    public RestApiResponse(String name, String description, List<String> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }

    // Domain -> Response
    public static RestApiResponse of(RestApiDomain restApiDomain) {
        return RestApiResponse.builder()
                .name(restApiDomain.getName())
                .description(restApiDomain.getDescription())
                .items(restApiDomain.getItems())
                .build();
    }

    // List<Domain> -> Response
    public static List<RestApiResponse> listOf(List<RestApiDomain> restApiResponses) {
        return restApiResponses.stream()
                .map(RestApiResponse::of)
                .collect(Collectors.toList());
    }
}
