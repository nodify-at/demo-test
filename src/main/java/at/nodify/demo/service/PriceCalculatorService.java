package at.nodify.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Service
public class PriceCalculatorService {

    public Double calculate(Stream<Double> numbers) {
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        numbers.forEach(number -> total.updateAndGet(v -> v + number));
        return total.get();
    }
}
