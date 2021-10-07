package racinggame.domain;

import racinggame.domain.exception.TryOutOfRangeException;
import racinggame.domain.exception.WithOutCarException;
import racinggame.domain.strategy.MovableStrategy;
import racinggame.domain.strategy.RacingMovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String COMMA = ",";
    private static final int MIN_VALUE_BY_CAR = 1;

    private final List<Race> races;

    private MovableStrategy moveStrategy = new RacingMovableStrategy();

    private RacingGame(String carNames, int tryCount) {
        validate(carNames, tryCount);
        races = startRace(lineUp(carNames), tryCount);
    }

    public static RacingGame of(String carNames, int tryCount) {
        return new RacingGame(carNames, tryCount);
    }

    private List<Car> lineUp(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(COMMA);
        for(String name : names) {
            cars.add(Car.from(Name.from(name)));
        }
        return cars;
    }

    private List<Race> startRace(List<Car> cars, int tryCount) {
        List<Race> races = new ArrayList<>();
        Race race = Race.of(cars, moveStrategy);
        while (tryCount > 0) {
            race = race.start();
            races.add(race);
            tryCount--;
        }
        return races;
    }

    public List<Car> findWinningCars () {
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

}
