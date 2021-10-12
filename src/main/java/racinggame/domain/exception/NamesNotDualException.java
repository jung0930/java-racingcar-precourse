package racinggame.domain.exception;

public class NamesNotDualException extends IllegalArgumentException {

    private static final String NAMES_NOT_DUAL_ERROR_MESSAGE = "[ERROR] 이름은 최소 두개 이상 입력하여야 합니다.";

    public NamesNotDualException() {
        super(NAMES_NOT_DUAL_ERROR_MESSAGE);
    }

}
