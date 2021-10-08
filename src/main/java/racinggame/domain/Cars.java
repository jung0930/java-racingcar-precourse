package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
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

    private void addWinningCar(List<Car> winners, Car fastestCar, Car comparisonCar) {
        if (fastestCar.compareDistance(comparisonCar) == 0) {
            winners.add(comparisonCar);
        }
    }

    private Car findFastestCar() {
        Car fastestCar = cars.get(0);
        for (Car car : cars) {
            fastestCar = car.findFasterCar(fastestCar);
        }
        return fastestCar;
    }

    public List<Car> value() {
        return cars;
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
