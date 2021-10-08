package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.domain.strategy.RacingMovableStrategy;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingCarController {

    public void play() {
        Cars cars = Cars.from(InputView.inputCarNames());
        int tryCount = Integer.parseInt(InputView.inputTryCount());

        RacingGame racingGame = RacingGame.of(cars, tryCount, new RacingMovableStrategy());
        OutputView.printExecutionResultText();
        for (int i = 0; i < tryCount; i++) {
            OutputView.printRace(racingGame.getRace(i));
        }
        OutputView.printWinningCars(racingGame);
    }

}
