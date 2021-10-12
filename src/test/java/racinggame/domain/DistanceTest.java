package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DistanceTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(Distance.from(5)).isInstanceOf(Distance.class);
    }

    @DisplayName("거리를 증가시킨다.")
    @Test
    void add() {
        Distance distance = Distance.from(5).increase();
        assertThat(distance).isEqualTo(Distance.from(6));
    }

}