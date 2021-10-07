package racinggame.domain.exception;

public class WithOutCarException extends IllegalArgumentException {

    private static final String WITH_OUT_CAR_ERROR_MESSAGE = "[ERROR] 자동차의 대수가 1대 이상이어야 합니다.";

    public WithOutCarException() {
        super(WITH_OUT_CAR_ERROR_MESSAGE);
    }

}
