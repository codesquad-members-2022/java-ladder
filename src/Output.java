import java.util.List;

public class Output {

    StringBuilder sb = new StringBuilder();

    public void printLadder(List<List<String>> ladder, List<String> name){
        printName(name);
        for (int i = 0; i < ladder.size(); i++) {
            makeColumn(ladder.get(i));
        }
        System.out.println(sb);
    }

    public StringBuilder makeColumn(List<String> ladderLine){
        for (int i = 0; i < ladderLine.size(); i++) {
            sb.append(ladderLine.get(i));
        }
        sb.append("\n");
        return sb;
    }
    public StringBuilder printName(List<String> name){
        for (int i = 0; i < name.size(); i++) {
            System.out.print(name.get(i)+ "   ");
        }
        sb.append("\n");
       return sb;
    }

}
