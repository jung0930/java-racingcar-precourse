package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.RacingGame;
import racinggame.domain.Round;

import java.util.List;

public final class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printExecutionResultText() {
        System.out.println();
        System.out.println("실행결과");
    }

    public static void printRaces(final RacingGame racingGame) {
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            OutputView.printRace(racingGame.getRace(i));
        }
    }

    private static void printRace(final Round round) {
        List<Car> cars = round.cars().value();
        for (Car car : cars) {
            System.out.println(car.name() + " : " + printDistance(car.distance()));
        }
        System.out.println();
    }

    private static String printDistance(final int addCount) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < addCount; i++) {
            distance.append("-");
        }
        return distance.toString();
    }

    public static void printWinningCars(final RacingGame racingGame) {
        StringBuilder winners = new StringBuilder();
        List<Car> cars = racingGame.findWinningCars().value();
        for (int i = 0; i < cars.size() - 1; i++) {
            winners.append(cars.get(i).name()).append(",");
        }
        winners.append(cars.get(cars.size() - 1).name());
        System.out.println("최종 우승자는 " + winners.toString() + " 입니다.");
    }

}
