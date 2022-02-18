package view;

public class Output {
    public static void messageAboutLadder(String info) {
        System.out.println("사다리 결과\n");
        System.out.println(info);
    }

    public static void messageAboutResult(String resultInfo){
        if (resultInfo.equals("춘식이")){
            System.out.println("게임을 종료합니다.");
            return;
        }
        System.out.println("실행 결과");
        System.out.println(resultInfo);
    }
}
