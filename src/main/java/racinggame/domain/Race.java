package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

import java.util.Objects;

public class Race {

    private final Cars cars;
    private final MovableStrategy strategy;

    private Race(Cars cars, MovableStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public static Race of(Cars cars, MovableStrategy strategy) {
        return new Race(cars, strategy);
    }

    public Race start() {
        return new Race(cars.move(strategy), strategy);
    }

    public Cars findFastestCars() {
        return cars.findFastestCars();
    }

    public Cars cars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(cars, race.cars) &&
                Objects.equals(strategy, race.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, strategy);
    }
}
