package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.ForwardMovableStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertAll(
                () -> assertThat(Car.from(Name.from("abcde"))).isInstanceOf(Car.class),
                () -> assertThat(Car.of(Name.from("abcde"), Distance.init())).isInstanceOf(Car.class)
        );
    }

    @DisplayName("Car를 이동시킨다.")
    @Test
    void move() {
        Car car = Car.of(Name.from("abcde"), Distance.from(5));
        Car movedCar = Car.of(Name.from("abcde"), Distance.from(6));

        assertThat(car.move(new ForwardMovableStrategy())).isEqualTo(movedCar);
    }

    @DisplayName("더 빠른 Car을 찾는다.")
    @Test
    void findFasterCar() {
        Car carA = Car.of(Name.from("A"), Distance.from(5));
        Car carB = Car.of(Name.from("B"), Distance.from(1));

        assertThat(carA.findFasterCar(carB)).isEqualTo(carA);
    }

}
