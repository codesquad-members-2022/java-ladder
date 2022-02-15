package dukcode.view;


import java.util.Scanner;

public class ScanView {

    private final Scanner sc;

    public ScanView(Scanner sc) {
        this.sc = sc;
    }

    public int getNumPlayer() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }
    public int getHeight() {
        System.out.println("최대 사다리 높이 는 몇 개 인가요?");
        return sc.nextInt();
    }

}
