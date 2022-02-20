import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {

    private static final String LADDER_LINE = "-----";
    private static final String LADDER_BLANK = "     ";
    private static final String LADDER_STICK = "|";

    private int heightLadder;
    private List<List<String>> ladder;
    private List<String> names;
    private boolean isPreLine = true;

    public Ladder(String playerName, int heightLadder) {
        this.heightLadder = heightLadder;
        this.ladder = new ArrayList<>();
        this.names = setPlayerName(playerName);
    }


    public List<String> setPlayerName(String playerName){
        names = Arrays.asList(playerName.split("\\s*,\\s*"));

        return names;
    }

    public List<List<String>> makeLadder(){
        for (int i = 0; i < heightLadder; i++) {
            List<String> ladderLine = new ArrayList<>();
            ladder.add(makeLadderLine(ladderLine));
        }
        return ladder;
    }

    public List<String> makeLadderLine(List<String> ladderArr){
        isPreLine = true;
        int width = names.size() * 2 - 1;
        for (int i = 0; i < width; i++) {
            makeStick(ladderArr, i);
            makeLine(ladderArr, i);
        }
        return ladderArr;
    }


    public List<String> makeLine (List<String> line, int j){
        if (j % 2 == 1) {
            randomLine(line);
        }
        return line;
    }


    public List<String> randomLine(List<String> line){
        Random ran = new Random();

        if (ran.nextBoolean() && isPreLine){
            line.add(LADDER_LINE);
            isPreLine = false;
            return line;
        }
        line.add(LADDER_BLANK);
        isPreLine = true;
        return line;
    }


    public List<String> makeStick(List<String> line, int j){
        if (j % 2 == 0 ) {
            line.add(LADDER_STICK);
            return line;
        }
        return line;
    }

}
