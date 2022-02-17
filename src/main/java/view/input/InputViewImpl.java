package view.input;

import domain.user.User;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputViewImpl implements InputView {

    private static InputViewImpl instance;

    private static final String USERS_PROMPT = "Users > ";
    private static final String HEIGHT_PROMPT = "height > ";

    private Validator validator;
    private Scanner scanner = new Scanner(System.in);

    private InputViewImpl(Validator validator) {
        this.validator = validator;
    }

    public static InputView getInstance(Validator validator) {
        if (instance == null) {
            instance = new InputViewImpl(validator);
        }
        return instance;
    }

    @Override
    public List<User> inputUsers() {
        try {
            requestInputUserNames();
            String inputLine = inputString();
            List<User> users = parseUsers(inputLine);
            validateUsers(users);
            return users;
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputUsers();
    }

    private void validateUsers(List<User> users) {
        users.forEach(validator::validateUserName);
        validator.validateDuplicateUsers(users);
        validator.validateNumberOfUsers(users);
    }

    private void requestInputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하셔야하고, 이름은 5자를 넘길 수 없습니다.)");
        System.out.print(USERS_PROMPT);
    }

    private List<User> parseUsers(String inputLine) {
        return Stream.of(inputLine.split(","))
                    .map(String::trim)
                    .map(User::new)
                    .collect(Collectors.toList());
    }

    @Override
    public int inputHeight() {
        requestInputHeight();
        try {
            int intHeight = inputInt();
            validator.heightValidate(intHeight);
            return intHeight;
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputHeight();
    }

    private void requestInputHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        System.out.print(HEIGHT_PROMPT);
    }

    private int inputInt() {
        String strInput = inputString();
        try {
            int intInput = Integer.parseInt(strInput);
            return intInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private String inputString() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
