import java.util.ArrayList;
import java.util.List;

public class Output {

    StringBuilder sb = new StringBuilder();

    public void printLadder2(List<List<String>> ladder){
        for (int i = 0; i < ladder.size(); i++) {
            makeColumn2(ladder.get(i));
        }
        System.out.println(sb);
    }

    public StringBuilder makeColumn2(List<String> ladderLine){
        for (int i = 0; i < ladderLine.size(); i++) {
            sb.append(ladderLine.get(i));
        }
        sb.append("\n");
        return sb;
    }


}
