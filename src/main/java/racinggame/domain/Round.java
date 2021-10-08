package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

import java.util.Objects;

public class Round {

    private final Cars cars;
    private final MovableStrategy strategy;

    private Round(Cars cars, MovableStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public static Round of(Cars cars, MovableStrategy strategy) {
        return new Round(cars, strategy);
    }

    public Round start() {
        return new Round(cars.move(strategy), strategy);
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
        Round round = (Round) o;
        return Objects.equals(cars, round.cars) &&
                Objects.equals(strategy, round.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, strategy);
    }
}
