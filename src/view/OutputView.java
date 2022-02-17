package view;

import java.util.ArrayList;

public class OutputView {
    private static final String userNumberMessage = "참여할 사람은 몇 명인가요?";
    private static final String sadariNumberMessage = "최대 사다리 높이는 몇 개인가요?";
    private static final String userNamesMessage = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String invalidUserNamesMessage = "이름의 길이가 너무 깁니다. 다시 입력하세요";
    private static final char sero = '|';
    private static final String garo = "-----";
    private static final String space = "     ";

    public static void printUserNumberMessage(){

        System.out.println(userNumberMessage);
    }

    public static void printSadariNumberMessage(){

        System.out.println(sadariNumberMessage);
    }

    public static void printUserNames(String[] userNames){
        for(String eachUserName: userNames){
            System.out.printf("%5s ",eachUserName);
        }
        System.out.println();
    }

    public static void printGraphicalSadari(ArrayList<boolean[]> sadari){
        StringBuilder graphicSadari = new StringBuilder();
        for(boolean[] line : sadari){
            graphicSadari.append( lineToStringline(line) );
        }
        System.out.println(graphicSadari);
    }

    private static StringBuilder lineToStringline(boolean[] line){
        StringBuilder sb = new StringBuilder();
        sb.append("  "+sero);
        for(boolean i : line) {
            sb.append( garoOrSpace(i) );
            sb.append(sero);
        }
        sb.append("\n");
        return sb;
    }

    private static <E> String garoOrSpace(E sadariElement){
        if(sadariElement.equals(true)){
            return garo;
        }
        return space;
    }

    public static void printUserNamesMessage(){
        System.out.println(userNamesMessage);
    }

    public static void printInvalidUserNamesMessage() {
        System.out.println(invalidUserNamesMessage);
    }

}
