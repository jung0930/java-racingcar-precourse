package racinggame.domain;

import java.util.Comparator;
import java.util.Objects;

public class Distance implements Comparator<Distance> {

    private static final int ADD = 1;
    private static final int INIT = 0;

    private final int distance;

    private Distance() {
        this.distance = INIT;
    }

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance init() {
        return new Distance();
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    public Distance add() {
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

    @Override
    public int compare(Distance distance1, Distance distance2) {
        if (distance1.distance > distance2.distance) {
            return 1;
        } else if (distance1.distance == distance2.distance) {
            return 0;
        }
        return -1;
    }

}
