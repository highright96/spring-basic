package dev.highright96.restapi;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RestApiService {

    public List<RestApiResponse> findAll() {

        List<String> itemList1 = Arrays.asList("item1", "item2");
        List<String> itemList2 = Arrays.asList("item3", "item4");

        RestApiDomain restApiDomain1 = RestApiDomain.builder()
                .name("james")
                .description("desc1")
                .items(itemList1)
                .build();

        RestApiDomain restApiDomain2 = RestApiDomain.builder()
                .name("kevin")
                .description("desc2")
                .items(itemList2)
                .build();

        List<RestApiDomain> domains = Arrays.asList(restApiDomain1, restApiDomain2);
        return RestApiResponse.listOf(domains);
    }

    public Long save(RestApiRequest restApiRequest) {
        return 1L;
    }
}
