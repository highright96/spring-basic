package dev.highright96.junit.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalculatorService {

    private final CalculatorRepository calculatorRepository;

    public int sum(int x, int y) {
        return this.calculatorRepository.sum(x, y);
    }

    public int minus(int x, int y) {
        return this.calculatorRepository.minus(x, y);
    }
}
