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

}
