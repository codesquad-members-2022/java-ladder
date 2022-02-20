package dukcode.view;

import java.util.Arrays;
import java.util.Scanner;

public class ScanView {

    private final Scanner sc;

    public ScanView(Scanner sc) {
        this.sc = sc;
    }

    public String[] getPlayerName() {
        System.out.println("참여할 사람의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        String[] PlayerNames = Arrays.stream(sc.nextLine().split(",")).map(String::trim).toArray(String[]::new);
        System.out.println();
        return PlayerNames;
    }

    public String[] getResults() {
        System.out.println("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요");
        String[] results = Arrays.stream(sc.nextLine().split(",")).map(String::trim).toArray(String[]::new);
        System.out.println();
        return results;
    }

    public int getHeight() {
        System.out.println("최대 사다리 높이 는 몇 개 인가요?");
        int height = sc.nextInt();
        System.out.println();
        sc.nextLine();
        return height;
    }

    public String getPlayerNameToShowResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String name = sc.nextLine();
        System.out.println();
        return name;
    }
}
