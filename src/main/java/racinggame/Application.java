package racinggame;

import racinggame.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController controller = new RacingCarController();
        controller.play();
    }
}
