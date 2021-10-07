package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final MovableStrategy strategy;

    private Race(List<Car> cars, MovableStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public static Race of(List<Car> cars, MovableStrategy strategy) {
        return new Race(cars, strategy);
    }

    public Race start() {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(strategy));
        }
        return new Race(movedCars, strategy);
    }

    public List<Car> findFastestCars() {
        List<Car> winners = new ArrayList<>();
        Car fastestCar = findFastestCarDistance();
        for(Car car : cars) {
            addWinningCar(winners, fastestCar, car);
        }
        return winners;
    }

    private void addWinningCar(List<Car> winners, Car fastestCar, Car comparisonCar) {
        if(fastestCar.compareDistance(comparisonCar) == 0) {
            winners.add(comparisonCar);
        }
    }

    private Car findFastestCarDistance() {
        Car fastestCar = cars.get(0);
        for(Car car : cars) {
            fastestCar = findFasterDistanceCar(fastestCar, car);
        }
        return fastestCar;
    }

    private Car findFasterDistanceCar(Car fastestCar, Car comparisonCar) {
        if(fastestCar.compareDistance(comparisonCar) == 1) {
            return comparisonCar;
        }
        return fastestCar;
    }

}
