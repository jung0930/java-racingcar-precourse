package racinggame.domain;

import racinggame.domain.strategy.MovableStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private Cars(final Names names) {
        this.cars = convertCarNames(names);
    }

    public static Cars from(final Names names) {
        return new Cars(names);
    }

    public static Cars from(final List<Car> cars) {
        return new Cars(cars);
    }

    private List<Car> convertCarNames(final Names names) {
        List<Car> cars = new ArrayList<>();
        for (Name name : names.value()) {
            cars.add(Car.from(name));
        }
        return cars;
    }

    public Cars move(final MovableStrategy strategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(strategy));
        }
        return new Cars(movedCars);
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
