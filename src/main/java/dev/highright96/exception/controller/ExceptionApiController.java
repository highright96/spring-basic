package dev.highright96.exception.controller;

import dev.highright96.exception.dto.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/exception")
public class ExceptionApiController {

    @GetMapping
    public User get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping
    public User post(@Valid @RequestBody User user) {
        System.out.println("user = " + user);
        return user;
    }

}
