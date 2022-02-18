import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private Random ran = new Random();
    private int playerCount;
    private int heightLadder;
    private List<List<String>> ladder;


    public Ladder(int playerCount, int heightLadder) {
        this.playerCount = playerCount;
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
        if (ran.nextBoolean()){
            line.add("     ");
            return line;
        }
        line.add("-----");
        return line;
    }


    public List<String> makeStick(List<String> line, int j){
        if (j % 2 == 0 ) {
            line.add("|");
            return line;
        }
        return line;
    }

}
