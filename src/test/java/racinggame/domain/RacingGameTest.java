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
        assertThat(RacingGame.of(Cars.from(Names.from("a,b,c,d,e")), TryCount.from(3), new ForwardMovableStrategy())).isInstanceOf(RacingGame.class);
    }

}
