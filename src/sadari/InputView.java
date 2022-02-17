package sadari;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private List<String> players;

    public List<String> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = scanner.next().split(",");
        for (String name : names) {
            validPlayerNames(name);
        }
        players = Arrays.asList(names);
//        players = Arrays.asList(scanner.next().split(","));
        //리턴을 리스트로 보낼까?.?
        return Arrays.asList(names);
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public void printNames() {
        System.out.println("실행결과");
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (String player : players) {
            String modifiedPlayerName = something(player);
            sb.append(modifiedPlayerName);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private String something(String str) {
        if (str.length() == 5) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat((5 - str.length()) / 2));
        sb.append(str);
        sb.append(" ".repeat(5 - sb.length()));
        return sb.toString();
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public void validPlayerNames(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 너무 깁니다. 5글자 이내로 입력해주세요.");
        }
    }

}
