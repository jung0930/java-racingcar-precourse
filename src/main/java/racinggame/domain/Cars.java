package racinggame.domain;

import racinggame.domain.exception.TryOutOfRangeException;
import racinggame.domain.exception.WithOutCarException;
import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final String COMMA = ",";
    private static final int MIN_VALUE_BY_CAR = 1;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    private Cars(String carNames) {
        validate(carNames);
        this.cars = addCars(carNames);
    }

    public static Cars from(String carNames) {
        return new Cars(carNames);
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private List<Car> addCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = carNames.split(COMMA);
        for (String name : names) {
            cars.add(Car.from(Name.from(name)));
        }
        return cars;
    }

    public Cars move(MovableStrategy strategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(strategy));
        }
        return new Cars(movedCars);
    }

    public Cars findFastestCars() {
        List<Car> winners = new ArrayList<>();
        Car fastestCar = findFastestCar();
        for (Car car : cars) {
            addWinningCar(winners, fastestCar, car);
        }
        return new Cars(winners);
    }

    private Car findFastestCar() {
        Car fastestCar = cars.get(0);
        for (Car car : cars) {
            fastestCar = car.findFasterCar(fastestCar);
        }
        return fastestCar;
    }

    private void addWinningCar(List<Car> winners, Car fastestCar, Car comparisonCar) {
        if (fastestCar.compareDistance(comparisonCar) == 0) {
            winners.add(comparisonCar);
        }
    }

    public List<Car> value() {
        return cars;
    }

    private void validate(String carNames) {
        if (carNames.split(COMMA).length < MIN_VALUE_BY_CAR) {
            throw new WithOutCarException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
