package src.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputNumber(String inputGuide) {
        System.out.println(inputGuide);
        String numberString = "";
        try {
            numberString = scanner.nextLine();
            validate(numberString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputNumber(inputGuide);
        }
        return Integer.parseInt(numberString);
    }

    private void validate(String numberString) throws NumberFormatException {
        if (isNotAllNumber(numberString)) {
            throw new NumberFormatException("숫자만 입력해주세요.");
        }
    }

    private boolean isNotAllNumber(String numberString) {
        return numberString.chars().anyMatch(this::isNotNumber);
    }

    private boolean isNotNumber(int ch) {
        return  ch < '0' || '9' < ch;
    }

    public List<String> inputPlayers(String inputGuide) {
        System.out.println(inputGuide);
        try {
            String playerNameInput = scanner.nextLine();
            return getNamesFrom(playerNameInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayers(inputGuide);
        }
    }

    private List<String> getNamesFrom(String playerNameInput) {
        if (playerNameInput.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
        String[] namesArray = playerNameInput.split(",");
        return Arrays.stream(namesArray).map(String::trim).toList();
    }


}
