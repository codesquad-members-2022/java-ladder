package src.ladder;

import static src.ladder.LadderMaterial.*;

import java.util.ArrayList;
import java.util.List;


public class LadderRow {

    private List<String> ladderMaterials = new ArrayList<>();

    public LadderRow(int playerCount) {
        generateRow(playerCount);
    }

    private void generateRow(int playerCount) {
        sidePartRail();
        middlePart(playerCount);
        sidePartRail();
    }

    private void middlePart(int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            addLadderMaterial();
        }
    }

    private void addLadderMaterial() {
    }

    private void sidePartRail() {
        ladderMaterials.add(RAIL);
    }

}
