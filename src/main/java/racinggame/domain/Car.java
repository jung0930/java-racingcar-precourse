package racinggame.domain;

import java.util.Objects;

public final class Car {

    private final Name name;
    private final Distance distance;

    private Car(final Name name) {
        this.name = name;
        this.distance = Distance.init();
    }

    private Car(final Name name, final Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public static Car from(final Name name) {
        return new Car(name);
    }

    public static Car of(final Name name, final Distance distance) {
        return new Car(name, distance);
    }

    public String name() {
        return name.value();
    }

    public int distance() {
        return distance.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

}
