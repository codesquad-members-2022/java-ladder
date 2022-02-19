import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private int playerCount;
    private int heightLadder;
    private List<String> playerName;
    private static final String LADDER_ROW = "-----";
    private static final String LADDER_BLANK = "     ";
    private static final String LADDER_STICK = "|";
    private List<List<String>> ladder;


    public Ladder(int playerCount, int heightLadder) {
        //this.playerCount = playerCount;
        this.playerName = new ArrayList<>();
        this.heightLadder = heightLadder;
        this.ladder = new ArrayList<>();
    }

    public List<List<String>> makeLadder(){
        for (int i = 0; i < heightLadder; i++) {
            List<String> ladderLine = new ArrayList<>();
            ladder.add(makeLadderLine(ladderLine));
        }
        return ladder;
    }

    public List<String> makeLadderLine(List<String> ladderArr){
        int width = playerCount * 2 - 1;
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
        if (ran.nextBoolean()){
            line.add(LADDER_BLANK);
            return line;
        }
        line.add(LADDER_ROW);
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
