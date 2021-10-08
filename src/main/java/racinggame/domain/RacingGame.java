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

    private final List<Race> races;

    private RacingGame(String carNames, int tryCount, MovableStrategy strategy) {
        validate(carNames, tryCount);
        this.races = startRace(lineUp(carNames), tryCount, strategy);
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

    private List<Race> startRace(List<Car> cars, int tryCount, MovableStrategy strategy) {
        List<Race> races = new ArrayList<>();
        Race race = Race.of(Cars.from(cars), strategy);
        while (tryCount > 0) {
            race = race.start();
            races.add(race);
            tryCount--;
        }
        return races;
    }

    public Cars findWinningCars() {
        return races.get(races.size() - 1).findFastestCars();
    }

    public Race getRace(int index) {
        return races.get(index);
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
        return Objects.equals(races, that.races);
    }

    @Override
    public int hashCode() {
        return Objects.hash(races);
    }

}
