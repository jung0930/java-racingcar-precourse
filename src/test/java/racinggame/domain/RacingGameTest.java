package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.ForwardMovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(RacingGame.of(Cars.from("a,b,c,d,e"), TryCount.from(3), new ForwardMovableStrategy())).isInstanceOf(RacingGame.class);
    }

    @DisplayName("우승한 Cars를 찾는다.")
    @Test
    void findWinningCars() {
        RacingGame racingGame = RacingGame.of(Cars.from("a,b"), TryCount.from(3), new ForwardMovableStrategy());

        assertThat(racingGame.findWinningCars()).isEqualTo(Cars.from(Arrays.asList(Car.of(Name.from("a"), Distance.from(3)), Car.of(Name.from("b"), Distance.from(3)))));
    }

}
