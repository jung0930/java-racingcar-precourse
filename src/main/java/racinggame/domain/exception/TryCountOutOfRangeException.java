package racinggame.domain.exception;

public class TryCountOutOfRangeException extends IllegalArgumentException {

    private static final String TRY_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 1 이상 이어야 합니다.";

    public TryCountOutOfRangeException() {
        super(TRY_OUT_OF_RANGE_ERROR_MESSAGE);
    }

}