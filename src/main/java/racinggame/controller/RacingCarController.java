package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.domain.TryCount;
import racinggame.domain.strategy.RacingMovableStrategy;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingCarController {

    public void play() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            start();
        }
    }

    public void start() {
        Cars cars = Cars.from(InputView.inputCarNames());
        TryCount tryCount = TryCount.from(Integer.parseInt(InputView.inputTryCount()));

        RacingGame racingGame = RacingGame.of(cars, tryCount, new RacingMovableStrategy());
        OutputView.printExecutionResultText();
        OutputView.printRaces(racingGame);
        OutputView.printWinningCars(racingGame);
    }

}
