package ladder;

import java.util.Scanner;

public class Input {
    public int[] getParam() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여 인원수?");
        int people = sc.nextInt();
        System.out.println("최대 사다리 높이?");
        int ladderHeight = sc.nextInt();
        return new int[]{people, ladderHeight};
    }
}
