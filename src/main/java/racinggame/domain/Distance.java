package racinggame.domain;

import java.util.Comparator;
import java.util.Objects;

public final class Distance {

    private static final int ADD = 1;
    private static final int INIT = 0;

    private final int distance;

    private Distance(final int distance) {
        this.distance = distance;
    }

    public static Distance init() {
        return new Distance(INIT);
    }

    public static Distance from(final int distance) {
        return new Distance(distance);
    }

    public Distance increase() {
        return new Distance(distance + ADD);
    }

    public int value() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

}
