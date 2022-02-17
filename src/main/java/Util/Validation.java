package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final int MIN_PLAYER = 2;
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_PLAYER = 10;
    private static final String PLAYER_ERROR_MESSAGE = "플레이어 수는 2명이상 10명이하로 가능합니다.";
    private static final String HEIGHT_ERROR_MESSGAE = "사다리의 높이는 1이상이어야 합니다.";
    private static final String INPUT_REGEX = "^([\\w]{1,5},{1}){1,9}([\\w]{1,5}){1}";
    private static final String INPUT_ERROR_MESSAGE = "입력을 확인해주세요.";

    public static int checkPlayers(int count) {
        if(count < MIN_PLAYER || count > MAX_PLAYER) {
            throw new IllegalArgumentException(PLAYER_ERROR_MESSAGE);
        }
        return count;
    }

    public static int checkHeight(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSGAE);
        }
        return height;
    }

    public static void checkInputNames(String input) {
        Pattern pattern = Pattern.compile(INPUT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if(!matcher.matches()) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
