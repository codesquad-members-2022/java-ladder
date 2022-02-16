package sadari;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputPeople(){
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public int inputHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void close(){
        if (scanner != null) {
            scanner.close();
        }
    }

}
