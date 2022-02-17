package src.ladder;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputNumber() {
        String numberString = "";
        try {
            numberString = scanner.nextLine();
            validate(numberString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputNumber();
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



}
