package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    public static final String SHORTENING = "..";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static InputValidator validator = new InputValidator();

    private InputView() {
    }

    public static int inputPositiveNumber(String msg) throws IOException {
        printMessage(msg);
        int posNumber = Integer.parseInt(br.readLine());
        validator.validatePositiveNumber(posNumber);
        return posNumber;
    }

    public static String[] inputStringWithDelimiter(String msg, String delimiter, int max) throws IOException {
        printMessage(msg);
        return cutToMaximumLength(br.readLine().split(delimiter));
    }

    public static String[] cutToMaximumLength(String[] split) {
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            cut(split, i, s);
        }
        return split;
    }

    private static void cut(String[] split, int i, String s) {
        if (s.length() > LadderGameManager.MAX_NAME_LENGTH) {
            StringBuilder sb = new StringBuilder(s.substring(0, LadderGameManager.MAX_NAME_LENGTH - SHORTENING.length()));
            sb.append(SHORTENING);
            split[i] = sb.toString();
        }
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }

    public static void close() throws IOException {
        br.close();
    }
}
