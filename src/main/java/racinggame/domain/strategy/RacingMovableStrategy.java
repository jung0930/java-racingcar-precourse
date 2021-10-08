package racinggame.domain.strategy;

import nextstep.utils.Randoms;

public class RacingMovableStrategy implements MovableStrategy {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int FORWARD_STANDARD = 3;

    public boolean isMoveable() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) > FORWARD_STANDARD;
    }

}
