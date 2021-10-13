package racinggame.domain.exception;

public class NameEmptyOrNullException extends IllegalArgumentException {

    private static final String NAME_EMPTY_OR_NULL_ERROR_MESSAGE = "[ERROR] 이름을 입력해주세요.";

    public NameEmptyOrNullException() {
        super(NAME_EMPTY_OR_NULL_ERROR_MESSAGE);
    }

}
