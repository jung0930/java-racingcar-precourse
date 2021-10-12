package racinggame.domain;

import racinggame.domain.exception.TryCountOutOfRangeException;

public final class TryCount {

    private static final int MIN_VALUE_BY_TRY_COUNT = 1;

    private final int tryCount;

    private TryCount(final int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    public static TryCount from(final int tryCount) {
        return new TryCount(tryCount);
    }

    public boolean isSame(final int tryCount) {
        return this.tryCount == tryCount;
    }

    public int value() {
        return tryCount;
    }

    private void validate(final int tryCount) {
        if (tryCount < MIN_VALUE_BY_TRY_COUNT) {
            throw new TryCountOutOfRangeException();
        }
    }

}
