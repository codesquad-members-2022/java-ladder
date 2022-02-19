import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public String playerName(String str){
        System.out.println(str);
        return scanner.nextLine();
    }

    public int height(String str){
        System.out.println(str);
        return scanner.nextInt();
    }

    public void close(){
        scanner.close();
    }
}
