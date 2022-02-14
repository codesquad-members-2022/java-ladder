package com.ttasjwi.LadderGame.view.output;

import com.ttasjwi.LadderGame.game.init.LadderElement;
import com.ttasjwi.LadderGame.view.output.OutputView;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class OutputViewImpl implements OutputView {

    @Override
    public void printLadder(LadderElement[][] ladder) {
        String sb = buildLadderString(ladder);
        System.out.print(sb);
    }

    private String buildLadderString(LadderElement[][] ladder) {
        int ladderHeight = ladder.length;
        int ladderWidth = ladder[0].length;
        StringBuilder sb = new StringBuilder();
        for (int y=0; y<ladderHeight; y++) {
            for (int x=0; x<ladderWidth; x++) {
                String symbol = ladder[y][x].getSymbol();
                sb.append(symbol);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
