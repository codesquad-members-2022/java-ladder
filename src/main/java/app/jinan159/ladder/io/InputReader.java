package app.jinan159.ladder.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader implements Closeable {

    private final static String Q_NUMBER_OF_PARTICIPANTS = "참여할 사람은 몇 명 인가요?(1명 이상)";
    private final static String Q_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?(1개 이상)";
    private final static String ALERT_NUMBER_REQUIRED = "(주의) 숫자만 입력해 주세요.";
    private final static String ALERT_VALIDATION_FAILED = "(주의) 입력하신 숫자를 다시한번 확인해 주세요.";
    private final static int READ_FAILED = -1;

    public final Scanner sc;

    public InputReader() {
        this.sc = new Scanner(System.in);
    }

    public InputReader(InputStream inputStream) {
        this.sc = new Scanner(inputStream);
    }

    public int readParticipantCount() {
        try {
            System.out.println(Q_NUMBER_OF_PARTICIPANTS);
            int count = readPositiveNumber();
            validateIsReadFaild(count);
            return count;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readParticipantCount();
        }
    }

    public int readHeight() {
        try {
            System.out.println(Q_MAX_LADDER_HEIGHT);
            int height = readPositiveNumber();
            validateIsReadFaild(height);
            return height;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readHeight();
        }
    }

    private void validateIsReadFaild(int input) {
        if (input == READ_FAILED) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

    private int readPositiveNumber() {
        try {
            int input = sc.nextInt();
            validateIsPositive(input);
            return input;
        } catch (NoSuchElementException e) {
            System.out.println(ALERT_NUMBER_REQUIRED);
            return READ_FAILED;
        }
    }

    private void validateIsPositive(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }
}
