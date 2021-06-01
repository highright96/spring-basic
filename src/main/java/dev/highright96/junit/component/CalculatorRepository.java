package dev.highright96.junit.component;

import org.springframework.stereotype.Component;

@Component
public interface CalculatorRepository {
    void init();

    int sum(int x, int y);

    int minus(int x, int y);
}
