package sadari;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private List<String> players;

    public List<String> inputPlayers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        players = Arrays.asList(scanner.next().split(","));
        return players;
    }

    public int inputHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public int numberOfPlayers(){
        return players.size();
    }

    public void printNames(){
        System.out.println("실행결과");
        for (String players : players) {
            System.out.print(players + " ");
        }
        System.out.println();
    }

    public void close(){
        if (scanner != null) {
            scanner.close();
        }
    }

}
