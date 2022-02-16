package view.input;

import java.util.Scanner;

public class InputViewImpl implements InputView {

    private static InputViewImpl instance;

    private static final String ENTRY_PROMPT = "entry > ";
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
    public int inputEntry() {
        System.out.println("참여할 사람은 몇 명인가요?");
        System.out.print(ENTRY_PROMPT);
        try {
            int intEntry = inputInt();
            validator.entryValidate(intEntry);
            return intEntry;
        } catch (IllegalArgumentException ile) {
            System.out.println(ile.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputEntry();
    }

    @Override
    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        System.out.print(HEIGHT_PROMPT);
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

    private int inputInt() {
        String strInput = scanner.nextLine();
        try {
            int intInput = Integer.parseInt(strInput);
            return intInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public void close() {
        scanner.close();
    }
}
