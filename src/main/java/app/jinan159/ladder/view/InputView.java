package app.jinan159.ladder.view;

import app.jinan159.ladder.LadderGame;
import app.jinan159.ladder.domain.Participant;
import app.jinan159.ladder.validation.InputValidator;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView implements Closeable {

    private final static String SPLITER = ",";
    private final static String Q_NAMES_OF_PARTICIPANTS = "참여할 사람을 입력해주세요.(5자 이하, 이름은 쉼표 '" + SPLITER + "' 로 구분해주세요.)";
    private final static String Q_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?(1개 이상)";
    private final static String ALERT_NUMBER_REQUIRED = "(주의) 숫자만 입력해 주세요.";

    private final Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public InputView(InputStream inputStream) {
        this.sc = new Scanner(inputStream);
    }

    public List<Participant> readParticipants() {
        System.out.println(Q_NAMES_OF_PARTICIPANTS);
        String[] names = readNames();
        return Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public int readHeight() {
        System.out.println(Q_MAX_LADDER_HEIGHT);
        return readPositiveNumber();
    }

    private String[] readNames() {
        try {
            String[] names = sc.nextLine().split(SPLITER);
            InputValidator.validateNames(names);
            return names;
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
            return readNames();
        }
    }

    private int readPositiveNumber() {
        try {
            int input = sc.nextInt();
            InputValidator.validateIsPositive(input);
            return input;
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(ALERT_NUMBER_REQUIRED);
            return readPositiveNumber();
        }
    }

    @Override
    public void close() {
        sc.close();
    }
}
