package racinggame.domain;

import racinggame.domain.exception.TryCountOutOfRangeException;

public class TryCount {

    private static final int MIN_VALUE_BY_TRY_COUNT = 1;

    private final int tryCount;

    private TryCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    public static TryCount from(int tryCount) {
        return new TryCount(tryCount);
    }

    public boolean isSame(int tryCount) {
        return this.tryCount == tryCount;
    }

    public int value() {
        return tryCount;
    }

    private void validate(int tryCount) {
        if (tryCount < MIN_VALUE_BY_TRY_COUNT) {
            throw new TryCountOutOfRangeException();
        }
    }

}
