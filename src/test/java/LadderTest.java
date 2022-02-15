import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void ladder() {
        Ladder ladder = new Ladder();
        OutputView output = new OutputView();

        int people = 3;
        int height = 5;
        output.printLadder(ladder.makeLadder(people, height));
    }
}