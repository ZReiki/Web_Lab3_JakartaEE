package ua.edu.nuos.web_lab3_jakartaee.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class MethodsTest {
    private Function f;
    private final double EPS = 1e-6;

    @BeforeEach
    void setUp() {
        f = new Function();
    }

    // Тестування методу обчислення функції
    @ParameterizedTest
    @CsvSource({
            "3.5,       -0.19085",
            "5.0,       -0.670259",
            "10.0,      -0.544021",
            "3.4,       0.934699",
            "0.0,       1.0",
            "-5.0,      0.080464",
            "3.4000008, 0.934699"
    })
    void fTest(double x, double expected) {
        double result = f.calculate(x);
        assertThat(result).isCloseTo(expected, offset(EPS));
    }

    // Тестування методу розрахунку кількості кроків табулювання
    @ParameterizedTest
    @CsvSource({
            "2.0, 5.0, 0.005, 601",
            "0.0, 1.0, 0.1,   11",
            "0.0, 1.0, 0.25,  5",
            "1.0, 2.0, 0.01,  101",
            "0.0, 0.0, 0.1,   1"
    })
    void calcNumberTabulationStepsTest(double a, double b, double h, int expected) {
        int result = new Tabulation(a, b, h, f).calcNumberTabulationSteps();
        assertThat(result).isEqualTo(expected);
    }

    // Тестування методу створення табульованого списку точок (x, y)
    @ParameterizedTest
    @CsvSource({
            "2.0, 5.0, 0.005, 0,     2.0,       0.173178",
            "2.0, 5.0, 0.005, 280,   3.4,       0.934699",
            "2.0, 5.0, 0.005, 600,   5.0,      -0.670259"
    })
    void generatePointsTest(double a, double b, double h, int index, double expectedX, double expectedY) {
        Point point = new Tabulation(a, b, h, f).getPoints().get(index);

        assertThat(point.x()).isCloseTo(expectedX, offset(EPS));
        assertThat(point.y()).isCloseTo(expectedY, offset(EPS));
    }

    // Тестування знаходження мінімального та максимального елементів списку з їх індексами
    @ParameterizedTest
    @CsvSource({
            "2.0, 5.0, 0.005,   228,    0.999998",
            "0.0, 1.0, 0.1,     0,      1.0"
    })
    void getMaxTest(double a, double b, double h, int expectedIndex, double expectedMax) {
        ListValue maxPair = new Tabulation(a, b, h, f).getMax();

        assertThat(maxPair.index()).isEqualTo(expectedIndex);
        assertThat(maxPair.value().y()).isCloseTo(expectedMax, offset(EPS));
    }

    @ParameterizedTest
    @CsvSource({
            "2.0, 5.0, 0.5, 6,  -0.670259",
            "0.0, 1.0, 0.1, 10, 0.291927"
    })
    void getMinTest(double a, double b, double h, int expectedIndex, double expectedMin) {
        ListValue minPair = new Tabulation(a, b, h, f).getMin();

        assertThat(minPair.index()).isEqualTo(expectedIndex);
        assertThat(minPair.value().y()).isCloseTo(expectedMin, offset(EPS));
    }
}