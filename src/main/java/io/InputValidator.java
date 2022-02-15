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
            if (input.isEmpty() || input.isBlank()) {
                throw new IllegalArgumentException("값을 입력해주세요.");
            }
            if (isContainNotNumberCharacter(input)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
            throw new IllegalArgumentException("int 범위를 초과합니다.");
        }
    }

    private boolean isPositiveInteger(int n) {
        return 0 < n;
    }

    private boolean isNumberCharacter(char ch) {
        return '0' <= ch && ch <= '9';
    }

    private boolean isContainNotNumberCharacter(String input) {
        for (char ch : input.toCharArray()) {
            if (!isNumberCharacter(ch)) {
                return true;
            }
        }
        return false;
    }
}
