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

    @DisplayName("거리간 비교하여 같으면 0을 반환한다.")
    @Test
    void compare_same() {
        Distance distance1 = Distance.from(2);
        Distance distance2 = Distance.from(2);

        assertThat(distance1.compare(distance2)).isEqualTo(0);
    }

    @DisplayName("거리간 비교하여 작으면 -1를 반환한다.")
    @Test
    void compare_smaller() {
        Distance distance1 = Distance.from(2);
        Distance distance2 = Distance.from(3);

        assertThat(distance1.compare(distance2)).isEqualTo(-1);
    }

    @DisplayName("거리간 비교하여 크면 1을 반환한다.")
    @Test
    void compare_bigger() {
        Distance distance1 = Distance.from(2);
        Distance distance2 = Distance.from(1);

        assertThat(distance1.compare(distance2)).isEqualTo(1);
    }

}
