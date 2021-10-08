package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Round;
import racinggame.domain.RacingGame;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printExecutionResultText() {
        System.out.println();
        System.out.println("실행결과");
    }

    public static void printRace(Round round) {
        List<Car> cars = round.cars().value();
        for (Car car : cars) {
            System.out.println(car.name() + " : " + printDistance(car.distance()));
        }
        System.out.println();
    }

    private static String printDistance(int addCount) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < addCount; i++) {
            distance.append("-");
        }
        return distance.toString();
    }

    public static void printWinningCars(RacingGame racingGame) {
        StringBuilder winners = new StringBuilder();
        List<Car> cars = racingGame.findWinningCars().value();
        for (int i = 0; i < cars.size() - 1; i++) {
            winners.append(cars.get(i).name()).append(",");
        }
        winners.append(cars.get(cars.size() - 1).name());
        System.out.println("최종 우승자는 " + winners.toString() + " 입니다.");
    }

}
