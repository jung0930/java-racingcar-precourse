package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.ForwardMovableStrategy;
import racinggame.domain.strategy.MovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    private Cars cars;
    private MovableStrategy strategy = new ForwardMovableStrategy();

    @BeforeEach
    void setup() {
        cars = Cars.from(Arrays.asList(Car.from(Name.from("a"))));
    }

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(Round.of(cars, strategy)).isInstanceOf(Round.class);
    }

}