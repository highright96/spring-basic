package dev.highright96.junit.controller;

import dev.highright96.junit.component.CalculatorService;
import dev.highright96.junit.dto.Req;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final CalculatorService calculatorService;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculatorService.sum(x, y);
    }

    @PostMapping("/minus")
    public int minus(@RequestBody Req req) {
        return calculatorService.minus(req.getX(), req.getY());
    }
}
