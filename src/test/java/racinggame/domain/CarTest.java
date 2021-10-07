package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.ForwardMovableStrategy;
import racinggame.domain.strategy.MovableStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @DisplayName("Car를 이동시킨다.")
    @Test
    void create() {
        Car car = Car.of(Name.from("abcde"), Distance.from(5));
        Car movedCar = Car.of(Name.from("abcde"), Distance.from(6));

        assertThat(car.move(new ForwardMovableStrategy())).isEqualTo(movedCar);
    }

}
