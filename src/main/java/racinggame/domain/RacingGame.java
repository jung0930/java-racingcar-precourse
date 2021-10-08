package racinggame.domain;

import racinggame.domain.exception.TryOutOfRangeException;
import racinggame.domain.exception.WithOutCarException;
import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    private static final String COMMA = ",";
    private static final int MIN_VALUE_BY_CAR = 1;

    private final List<Round> rounds;

    private RacingGame(String carNames, int tryCount, MovableStrategy strategy) {
        validate(carNames, tryCount);
        this.rounds = startRace(lineUp(carNames), tryCount, strategy);
    }

    public static RacingGame of(String carNames, int tryCount, MovableStrategy strategy) {
        return new RacingGame(carNames, tryCount, strategy);
    }

    private List<Car> lineUp(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(COMMA);
        for (String name : names) {
            cars.add(Car.from(Name.from(name)));
        }
        return cars;
    }

    private List<Round> startRace(List<Car> cars, int tryCount, MovableStrategy strategy) {
        List<Round> rounds = new ArrayList<>();
        Round round = Round.of(Cars.from(cars), strategy);
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

    private void validate(String nameList, int roundCount) {
        if (nameList.split(COMMA).length < MIN_VALUE_BY_CAR) {
            throw new WithOutCarException();
        }
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
