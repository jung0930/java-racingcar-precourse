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

    @DisplayName("숫자가 tryCount와 같은지 확인. 같으면 true")
    @Test
    void isSame_같으면_true() {
        assertAll(
                () -> assertThat(TryCount.from(5).isSame(5)).isTrue(),
                () -> assertThat(TryCount.from(4).isSame(4)).isTrue()
        );
    }

    @DisplayName("숫자가 tryCount와 같은지 확인. 다르면 false")
    @Test
    void isSame_다르면_false() {
        assertAll(
                () -> assertThat(TryCount.from(3).isSame(2)).isFalse(),
                () -> assertThat(TryCount.from(2).isSame(1)).isFalse()
        );
    }

}
