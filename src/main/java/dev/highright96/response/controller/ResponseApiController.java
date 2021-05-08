package dev.highright96.response.controller;

import dev.highright96.response.dto.RequestUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResponseApiController {

    // TEXT
    @GetMapping("/text")
    public String text(String account) {
        return account;
    }

    // JSON
    @PostMapping("/json")
    public RequestUser json(@RequestBody RequestUser user) {
        return user;
    }

    // ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<RequestUser> put(@RequestBody RequestUser user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
