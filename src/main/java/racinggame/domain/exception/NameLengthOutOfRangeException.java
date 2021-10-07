package racinggame.domain.exception;

public class NameLengthOutOfRangeException extends IllegalArgumentException {

    private static final String NAME_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 이름은 5글자 이하로 입력해주세요.";

    public NameLengthOutOfRangeException() {
        super(NAME_OUT_OF_RANGE_ERROR_MESSAGE);
    }

}
