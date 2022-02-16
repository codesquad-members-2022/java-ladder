package ladder.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    private static Input input = new Input();
    private static final int ELEMENTS_SIZE = 2;

    private InputView() {}
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        if (instance == null) {
            return new InputView();
        }
        return instance;
    }

    public List<Integer> getWidthAndHeight() {
        List<Integer> widthAndHeight = new ArrayList<>();

        while (widthAndHeight.size() < ELEMENTS_SIZE) {
            getValue(widthAndHeight);
        }
        return widthAndHeight;
    }

    private void getValue(List<Integer> list) {
        String value;
        try {
            value = input.br.readLine();
            validateNumber(value);
            list.add(Integer.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateNumber(String value) {
        if (Character.isDigit(Integer.parseInt(value))) {
            throw new NumberFormatException();
        }
    }

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
    }
}
