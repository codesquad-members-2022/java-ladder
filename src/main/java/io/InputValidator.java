package io;

public class InputValidator {

    public int positiveInteger(String input) throws IllegalArgumentException {
        try {
            int n = Integer.parseInt(input);
            validateNumber(n);
            return n;
        } catch (NumberFormatException e) {
            throw subdivideNumberFormatException(input);
        }
    }

    private void validateNumber(int n) {
        if (!isPositiveInteger(n)) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }

    private boolean isPositiveInteger(int n) {
        return 0 < n;
    }

    private boolean isNumberAscii(int ch) {
        return '0' <= ch && ch <= '9';
    }

    private boolean isContainNotNumberCharacter(String input) {
        return input.chars()
            .filter(ch -> !isNumberAscii(ch))
            .findAny()
            .isPresent();
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
