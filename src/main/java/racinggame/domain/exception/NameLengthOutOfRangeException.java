package racinggame.domain.exception;

public class NameLengthOutOfRangeException extends IllegalArgumentException {

    private static final String NAME_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 이름은 1에서 5글자 사이로 입력해주세요.";

    public NameLengthOutOfRangeException() {
        super(NAME_OUT_OF_RANGE_ERROR_MESSAGE);
    }

}
