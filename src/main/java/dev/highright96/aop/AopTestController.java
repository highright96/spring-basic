package dev.highright96.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class AopTestController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return name + id;
    }

    @PostMapping("/post")
    public AopTestRequest post(@RequestBody AopTestRequest aopTestRequest) {
        return aopTestRequest;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        Thread.sleep(2000);
    }
}
