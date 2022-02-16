import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public int ladderInfo(String str){
        System.out.println(str);
        return scanner.nextInt();
    }

    public void close(){
        scanner.close();
    }
}
