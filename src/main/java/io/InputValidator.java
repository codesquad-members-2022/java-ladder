package io;

public class InputValidator {

    public int positiveInteger(String input) throws IllegalArgumentException {
        try {
            int n = Integer.parseInt(input);
            if (!isPositiveInteger(n)) {
                throw new IllegalArgumentException("양수를 입력해주세요.");
            }
            return n;
        } catch (NumberFormatException e) {
            throw subdivideNumberFormatException(input);
        }
    }

    private boolean isPositiveInteger(int n) {
        return 0 < n;
    }

    private boolean isNumberCharacter(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private boolean isContainNotNumberCharacter(String input) {
        boolean contain = false;
        for (char ch : input.toCharArray()) {
            contain = !isNumberCharacter(ch);
        }
        return contain;
    }

    private IllegalArgumentException subdivideNumberFormatException(String input) {
        if (input.isEmpty() || input.isBlank()) {
            return new IllegalArgumentException("값을 입력해주세요.");
        }
        if (isContainNotNumberCharacter(input)) {
            return new IllegalArgumentException("숫자(정수)를 입력해주세요.");
        }
        return new IllegalArgumentException("int 범위를 초과합니다.");
    }
}
