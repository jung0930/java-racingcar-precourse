package racinggame.controller;

import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingCarController {

    public void play() {
        String carNames = InputView.inputCarNames();
        int tryCount = Integer.parseInt(InputView.inputTryCount());

        RacingGame racingGame = RacingGame.of(carNames, tryCount);
        ResultView.printGuiedText();
        for (int i = 0; i < tryCount; i++) {
            ResultView.printRace(racingGame.getRace(i));
        }
        ResultView.printWinningCars(racingGame);
    }

}
