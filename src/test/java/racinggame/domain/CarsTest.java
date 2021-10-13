package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.ForwardMovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(Cars.from(Names.from("a,b,c,d,e"))).isInstanceOf(Cars.class);
        assertThat(Cars.from(Arrays.asList(Car.from(Name.from("a")), Car.from(Name.from("b"))))).isInstanceOf(Cars.class);
    }

    @DisplayName("Cars를 이동시킨다.")
    @Test
    void move() {
        Cars cars = Cars.from(Arrays.asList(Car.from(Name.from("a")), Car.of(Name.from("b"), Distance.from(1))));
        Cars movedCars = Cars.from(Arrays.asList(Car.of(Name.from("a"), Distance.from(1)), Car.of(Name.from("b"), Distance.from(2))));

        assertThat(cars.move(new ForwardMovableStrategy())).isEqualTo(movedCars);
    }

    @DisplayName("가장 빠른 Cars를 찾는다.")
    @Test
    void findFastestCars() {
        Cars cars = Cars.from(Arrays.asList(Car.from(Name.from("a")), Car.of(Name.from("b"), Distance.from(2)), Car.of(Name.from("c"), Distance.from(2))));
        Cars fastestCars = Cars.from(Arrays.asList(Car.of(Name.from("b"), Distance.from(2)), Car.of(Name.from("c"), Distance.from(2))));

        assertThat(cars.findFastestCars()).isEqualTo(fastestCars);
    }

}
