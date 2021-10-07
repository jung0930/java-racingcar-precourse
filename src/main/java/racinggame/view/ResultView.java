package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Race;
import racinggame.domain.RacingGame;

import java.util.List;

public class ResultView {

    private ResultView() {}

    public static void printRace(Race race) {

    }

    public static void printWinningCars(RacingGame racingGame) {
        List<Car> cars = racingGame.findWinningCars();
    }

}
