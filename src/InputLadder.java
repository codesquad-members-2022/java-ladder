import java.util.Scanner;

public class InputLadder {

    Scanner sc = new Scanner(System.in);
    OutputLadder outputLadder = new OutputLadder();

    public int ladderInfo(String str){
        outputLadder.printRules(str);
        return sc.nextInt();
    }

    public void inputClose(){
        sc.close();
    }
}
