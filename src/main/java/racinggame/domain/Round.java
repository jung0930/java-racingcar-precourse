package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

public final class Round {

    private final Cars cars;
    private final MovableStrategy strategy;

    private Round(final Cars cars, final MovableStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public static Round of(final Cars cars, final MovableStrategy strategy) {
        return new Round(cars, strategy);
    }

    public Cars cars() {
        return cars;
    }

}
