package dev.highright96.validation.controller;

import dev.highright96.validation.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return getErrorResponseEntity(bindingResult);
        return ResponseEntity.ok(user);
    }

    private ResponseEntity<String> getErrorResponseEntity(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        bindingResult.getAllErrors().forEach(objectError -> {
            FieldError fieldError = (FieldError) objectError;
            String msg = objectError.getDefaultMessage();

            sb.append("field : ").append(fieldError.getField());
            sb.append("msg : ").append(msg);
        });
        return ResponseEntity.badRequest().body(sb.toString());
    }
}
