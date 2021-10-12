package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    private final List<Round> rounds;
    private final Cars cars;
    private final TryCount tryCount;
    private final MovableStrategy strategy;

    private RacingGame(Cars cars, TryCount tryCount, MovableStrategy strategy) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.strategy = strategy;
        this.rounds = startRounds();
    }

    public static RacingGame of(Cars cars, TryCount tryCount, MovableStrategy strategy) {
        return new RacingGame(cars, tryCount, strategy);
    }

    private List<Round> startRounds() {
        List<Round> rounds = new ArrayList<>();
        Round round = Round.of(cars, strategy);
        for(int i = 0; !tryCount.isSame(i); i++) {
            round = round.start();
            rounds.add(round);
        }
        return rounds;
    }

    public Cars findWinningCars() {
        return rounds.get(rounds.size() - 1).findFastestCars();
    }

    public Round getRace(int index) {
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
