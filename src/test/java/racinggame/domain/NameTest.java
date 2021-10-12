package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class NameTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(Name.from("abcde")).isInstanceOf(Name.class);
    }

    @DisplayName("빈값일 경우 exception 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validate_빈값(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.from(input));
    }

    @DisplayName("5글자를 초과하면 exception 발생")
    @Test
    void validate_5글자_초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> Name.from("abcdef"));
    }

}
