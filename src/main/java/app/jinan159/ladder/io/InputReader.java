package app.jinan159.ladder.io;

import app.jinan159.ladder.LadderGame;
import app.jinan159.ladder.meta.Participant;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader implements Closeable {

    private final static String SPLITER = ",";
    private final static String Q_NAMES_OF_PARTICIPANTS = "참여할 사람을 입력해주세요.(5자 이하, 이름은 쉼표 '" + SPLITER + "' 로 구분해주세요.)";
    private final static String Q_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?(1개 이상)";
    private final static String ALERT_NUMBER_REQUIRED = "(주의) 숫자만 입력해 주세요.";
    private final static String ALERT_VALIDATION_FAILED = "(주의) 입력하신 항목을 다시한번 확인해 주세요.";

    public final Scanner sc;

    public InputReader() {
        this.sc = new Scanner(System.in);
    }

    public InputReader(InputStream inputStream) {
        this.sc = new Scanner(inputStream);
    }

    public List<Participant> readParticipants() {
        System.out.println(Q_NAMES_OF_PARTICIPANTS);
        String[] names = readNames();
        return namesToParticipantList(names);
    }

    public int readHeight() {
        System.out.println(Q_MAX_LADDER_HEIGHT);
        return readPositiveNumber();
    }

    private String[] readNames() {
        try {
            String[] names = sc.nextLine().split(SPLITER);
            validateNames(names);
            return names;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return readNames();
        }
    }

    private List<Participant> namesToParticipantList(String[] names) {
        return Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    private int readPositiveNumber() {
        try {
            int input = sc.nextInt();
            validateIsPositive(input);
            return input;
        } catch (NoSuchElementException e) {
            System.out.println(ALERT_NUMBER_REQUIRED);
            return readPositiveNumber();
        }
    }

    private void validateIsPositive(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

    private void validateNames(String[] names) {
        for (String name : names) {
            validateNamesLength(name);
        }
    }

    private void validateNamesLength(String input) {
        if (input.length() > LadderGame.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

    @Override
    public void close() {
        sc.close();
    }
}
