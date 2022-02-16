package sadari;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    //TODO: 인풋을 받는 메서드 안에서 리스트를 만드는게 맞을까? 생각해보고 필요하면 수정하기
    public int inputPeople(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String people = scanner.nextLine();
        List<String> peopleList = Arrays.asList(people.split(","));
        return peopleList.size();
    }

    public int inputHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void close(){
        if (scanner != null) {
            scanner.close();
        }
    }

}
