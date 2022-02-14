package com.ttasjwi.LadderGame.game.init;

import com.ttasjwi.LadderGame.game.LadderElement;
import com.ttasjwi.LadderGame.game.LadderGame;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameInitializerImpl implements GameInitializer {

    private final LadderGame ladderGame;

    public void initLadder(int entry, int maxHeight) {
        int maxWidth = maxLadderWidth(entry);
        LadderElement[][] ladder = makeLadder(maxHeight, maxWidth);
        ladderGame.setLadder(ladder);
        return;
    }

    private LadderElement[][] makeLadder(int maxHeight, int maxWidth) {
        LadderElement[][] ladder = new LadderElement[maxHeight][maxWidth];
        for (int y = 0; y< maxHeight; y++) {
            for (int x = 0; x< maxWidth; x++) {
                ladder[y][x] = (x%2 == 0)
                        ? LadderElement.HORIZONTAL_LINE
                        : randomVerticalLine();
            }
        }
        return ladder;
    }

    private int maxLadderWidth(int entry) {
        return 2*entry - 1;
    }

    private LadderElement randomVerticalLine() {
        double randomFloat = Math.random();
        boolean randomBool = (0 <= randomFloat) && (randomFloat < 0.5);
        return (randomBool) ? LadderElement.VERTICAL_LINE : LadderElement.EMPTY_LINE;
    }

}
