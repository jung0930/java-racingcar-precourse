package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.ForwardMovableStrategy;
import racinggame.domain.strategy.MovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceTest {

    private Cars cars;
    private MovableStrategy strategy = new ForwardMovableStrategy();

    @BeforeEach
    void setup() {
        cars = Cars.from(Arrays.asList(Car.from(Name.from("a")), Car.of(Name.from("b"), Distance.from(3)), Car.of(Name.from("c"), Distance.from(3))));
    }

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(Race.of(cars, strategy)).isInstanceOf(Race.class);
    }

    @DisplayName("Race를 시작한다.")
    @Test
    void start() {
        Cars movedCars = Cars.from(Arrays.asList(Car.of(Name.from("a"), Distance.from(1)), Car.of(Name.from("b"), Distance.from(4)), Car.of(Name.from("c"), Distance.from(4))));
        Race startedRace = Race.of(movedCars, strategy);

        assertThat(Race.of(cars, strategy).start()).isEqualTo(startedRace);
    }

    @DisplayName("가장 빠른 Cars를 찾는다.")
    @Test
    void findFastestCars() {
        assertThat(Race.of(cars, strategy).findFastestCars())
                .isEqualTo(Cars.from(Arrays.asList(Car.of(Name.from("b"), Distance.from(3)), Car.of(Name.from("c"), Distance.from(3)))));
    }

}
