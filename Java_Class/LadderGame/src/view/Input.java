package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input{
    private final String PROMPT_NAMES = "참여자들의 이름을 쉼표(,)로 구분하여 입력해주세요\n> ";
    private final String PROMPT_LADDERHEIGHT = "최대 사다리 높이는 몇 개인가요?\n> ";
    private final String PROMPT_NOTNUMBER = "숫자를 입력해주세요\n> ";
    private final String PROMPT_LENGTHERROR = "이름은 5글자 이내로 입력해주세요\n> ";

    private List<String> names;
    private int ladderHeight;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void processInput() {
        try {
            names = receiveNameInput();
            ladderHeight = Integer.parseInt(receiveHeightInput());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private List<String> receiveNameInput() throws IOException {

        System.out.print(PROMPT_NAMES);
        List<String> tempList;
        while (!isValid(tempList = processToList(br.readLine()))) { //pobi,honux,crong,jk
            System.out.print(PROMPT_LENGTHERROR);
        }
        return tempList;
    }

    private String receiveHeightInput() throws IOException {
        System.out.print(PROMPT_LADDERHEIGHT);
        String input;
        while (!isValid((input = br.readLine()))) {
            System.out.print(PROMPT_NOTNUMBER);
        }
        return input;
    }

    private boolean isValid(List<String> names) {
        return names.stream()
            .allMatch(str -> str.length() <= 5);
    }

    private boolean isValid(String input) {
        if (input.matches("\\d+")) {
            return true;
        }
        return false;
    }

    private List<String> processToList(String nameInput) {
        return Arrays.stream(nameInput.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public List<String> getNameList() {
        return names;
    }

    public int getHeight() {
        return ladderHeight;
    }
}
