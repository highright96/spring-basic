package dev.highright96.validation.controller;

import dev.highright96.validation.dto.Item;
import dev.highright96.validation.validator.ItemRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/validation-v2")
public class ValidationControllerV2 {

    private final ItemRequestValidator itemValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        dataBinder.addValidators(itemValidator);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@Validated @RequestBody Item item) {
        return ResponseEntity.ok(item);
    }
}
