package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class NamesTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(Names.from("a,b,c,d")).isInstanceOf(Names.class);
    }

    @DisplayName("이름이 두개 미만이면 에러")
    @Test
    void validate_이름이_두개_미만() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Names.from("a");
        });
    }

    @DisplayName("이름이 중복되면 에러")
    @Test
    void validate_이름이_중복() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Names.from("a,b,c,d,a");
        });
    }

}
