package dev.highright96.validation.controller;

import dev.highright96.validation.dto.User;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/validation-v1")
public class ValidationControllerV1 {

    @PostMapping
    public ResponseEntity<User> user(@Valid @RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
