package src.ladder;

import static src.ladder.LadderMaterial.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import src.ladder.utils.RandomUtil;


public class LadderRow {

    private List<String> ladderMaterials = new ArrayList<>();

    public LadderRow(int playerCount) {
        generateRow(playerCount);
    }

    private void generateRow(int playerCount) {
        int partsLength = playerCount * 2 - 1;
        for (int i = 0; i < partsLength; i++) {
            addLadderMaterial(i);
        }
    }

    private void addLadderMaterial(int index) {
        if (index % 2 == 0) {
            ladderMaterials.add(RAIL);
            return;
        }
        if (hasStepPrevious(index)) {
            ladderMaterials.add(BLANK);
            return;
        }
        if (RandomUtil.nextBooleanWithPercentOf(30)) {
            ladderMaterials.add(STEP);
            return;
        }
        ladderMaterials.add(BLANK);
    }

    private boolean hasStepPrevious(int index) {
        if (isLeftMostStep(index)) {
            return false;
        }
        return Objects.equals(ladderMaterials.get(index - 2), STEP);
    }

    private boolean isLeftMostStep(int index) {
        return index == 1;
    }

    public List<String> getLadderMaterials() {
        return ladderMaterials;
    }

}
