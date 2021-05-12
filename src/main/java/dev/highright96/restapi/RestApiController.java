package dev.highright96.restapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/api/restapi")
@RequiredArgsConstructor
public class RestApiController {

    private final RestApiService restApiService;

    // TEXT
    @GetMapping("/text")
    public String text(String account) {
        return account;
    }

    // JSON
    @PostMapping("/json")
    public RestApiRequest json(@RequestBody RestApiRequest user) {
        return user;
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<RestApiRequest> put(@RequestBody RestApiRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // restApi practice
    @GetMapping
    public ResponseEntity<List<RestApiResponse>> findAll() {
        return ResponseEntity.ok(restApiService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody RestApiRequest restApiRequest) {
        Long savedId = restApiService.save(restApiRequest);
        return ResponseEntity.created(URI.create("/api/***/" + savedId)).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        //restApiService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
