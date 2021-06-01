package dev.highright96.junit.component;

import dev.highright96.junit.component.CalculatorRepository;
import dev.highright96.junit.component.MarketApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CalculatorRepositoryTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private CalculatorRepository calculatorRepository;

    @Test
    void calculatorRepositoryTest() {
        Mockito.when(marketApi.connect()).thenReturn(3000);

        calculatorRepository.init();
        int sum = calculatorRepository.sum(10, 10);
        int minus = calculatorRepository.minus(10, 10);

        assertThat(sum).isEqualTo(60000);
        assertThat(minus).isEqualTo(0);
    }

}