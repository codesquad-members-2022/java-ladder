import java.util.Scanner;

public class Input {

    Scanner sc = new Scanner(System.in);

    public int ladderInfo(String str){
        System.out.println(str);
        return sc.nextInt();
    }

    public void inputClose(){
        sc.close();
    }
}
