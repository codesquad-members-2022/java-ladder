package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Input {

    public static int getPeopleCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        System.out.print("> ");

        return sc.nextInt();
    }

    public static int getSadariHeight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("사다리의 높이는 몇인가요?");
        System.out.print("> ");

        return sc.nextInt();
    }

    public static ArrayList<String> getNamesList() {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람의 이름을 적어주세요. 각 이름은 최대 5글자이고, 콤마로 구분합니다.");
        System.out.println("> ");

        String names = sc.next();
        String[] namesArray = names.split(",");
        ArrayList<String> participants = new ArrayList<>();
        Collections.addAll(participants, namesArray);

        return participants;
    }
}
