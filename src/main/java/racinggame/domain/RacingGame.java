package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class RacingGame {

    private final Cars cars;
    private final TryCount tryCount;
    private final MovableStrategy strategy;
    private final List<Round> rounds;

    private RacingGame(final Cars cars, final TryCount tryCount, final MovableStrategy strategy) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.strategy = strategy;
        this.rounds = startRounds();
    }

    public static RacingGame of(final Cars cars, final TryCount tryCount, final MovableStrategy strategy) {
        return new RacingGame(cars, tryCount, strategy);
    }

    private List<Round> startRounds() {
        List<Round> rounds = new ArrayList<>();
        Round round = Round.of(cars, strategy);
        for (int i = 0; tryCount.smallerThan(i); i++) {
            round = round.start();
            rounds.add(round);
        }
        return rounds;
    }

    public Round getRace(final int index) {
        return rounds.get(index);
    }

    public int getTryCount() {
        return tryCount.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(rounds, that.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rounds);
    }

}
