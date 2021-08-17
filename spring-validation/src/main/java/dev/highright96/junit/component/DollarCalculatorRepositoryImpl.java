package dev.highright96.junit.component;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculatorRepositoryImpl implements CalculatorRepository {

    private final MarketApi marketApi;

    private int price;

    @Override
    public void init() {
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        return (x * price) + (y * price);
    }

    @Override
    public int minus(int x, int y) {
        return (x * price) - (y * price);
    }
}
