package com.company;

public class Organizer {
    int[] getSadariInfo() {
        int peopleCount = Input.getPeopleCount();
        int sadariHeight = Input.getSadariHeight();
        int[] answer = new int[]{peopleCount, sadariHeight};
        return answer;
    }

    void init() {
        int[] sadariInfo = getSadariInfo();
        Sadari sadari = new Sadari(sadariInfo[0], sadariInfo[1]);
        Print.printSadari(sadari);
        // main()에 사다리를 리턴해줘야 할까?
            // 사다리를 만든다기 보다는 사다리 게임을 하는 거니까... 사다리 없어도 괜찮지 않을까?
            // 근데 결과 보기 등의 인터렉션을 하려면 사다리를 리턴받아야 하나?
        // 아님. main이 아니라 Organizer가 게임을 진행하는 센터가 되도록.
            // 사다리 생성 이후에는 Organizer에서 커맨드 대기하고
            // Input - Organizer - Output의 상호작용으로 동작하게 하는 게 맞을듯
    }

}
