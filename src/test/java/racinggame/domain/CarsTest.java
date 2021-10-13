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
        // assertThat(Cars.from(Arrays.asList(Car.from(Name.from("a")), Car.from(Name.from("b"))))).isInstanceOf(Cars.class);
    }

}
