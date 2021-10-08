package racinggame.domain;

import racinggame.domain.exception.TryOutOfRangeException;
import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    private static final int MIN_VALUE_BY_CAR = 1;

    private final List<Round> rounds;

    private RacingGame(Cars cars, int tryCount, MovableStrategy strategy) {
        validate(tryCount);
        this.rounds = startRace(cars, tryCount, strategy);
    }

    public static RacingGame of(Cars cars, int tryCount, MovableStrategy strategy) {
        return new RacingGame(cars, tryCount, strategy);
    }

    private List<Round> startRace(Cars cars, int tryCount, MovableStrategy strategy) {
        List<Round> rounds = new ArrayList<>();
        Round round = Round.of(cars, strategy);
        while (tryCount > 0) {
            round = round.start();
            rounds.add(round);
            tryCount--;
        }
        return rounds;
    }

    public Cars findWinningCars() {
        return rounds.get(rounds.size() - 1).findFastestCars();
    }

    public Round getRace(int index) {
        return rounds.get(index);
    }

    private void validate(int roundCount) {
        if (roundCount < MIN_VALUE_BY_CAR) {
            throw new TryOutOfRangeException();
        }
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
