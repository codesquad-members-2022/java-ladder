package com.company;

import java.util.Scanner;

public class Input {

    public static int getPeopleCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        System.out.print("> ");

        return sc.nextInt();
    }

    public static int getSadariHeight() {
        Scanner sc = new Scanner(System.in); // Scanner를 멤버변수로 빼면 어떨까? 이렇게도 쓰나?
        System.out.println("사다리의 높이는 몇인가요?");
        System.out.print("> ");

        return sc.nextInt();
    }
}
