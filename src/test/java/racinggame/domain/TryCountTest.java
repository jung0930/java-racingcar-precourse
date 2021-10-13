package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
class TryCountTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(TryCount.from(5)).isInstanceOf(TryCount.class);
    }

    @DisplayName("tryCount가 1 미만일 경우 에러")
    @Test
    void create_1미만이면_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            TryCount.from(-1);
        });
    }

    @DisplayName("숫자가 tryCount보다 작으면 true")
    @Test
    void isSame_같으면_true() {
        assertAll(
                () -> assertThat(TryCount.from(5).smallerThan(4)).isTrue(),
                () -> assertThat(TryCount.from(4).smallerThan(3)).isTrue()
        );
    }

    @DisplayName("숫자가 tryCount보다 크거나 같으면 false")
    @Test
    void isSame_다르면_false() {
        assertAll(
                () -> assertThat(TryCount.from(3).smallerThan(4)).isFalse(),
                () -> assertThat(TryCount.from(2).smallerThan(3)).isFalse(),
                () -> assertThat(TryCount.from(2).smallerThan(2)).isFalse()
        );
    }

}
