package racinggame.domain.exception;

public class NamesDuplicateException extends IllegalArgumentException {

    private static final String NAMES_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 이름이 있습니다.";

    public NamesDuplicateException() {
        super(NAMES_DUPLICATE_ERROR_MESSAGE);
    }

}
