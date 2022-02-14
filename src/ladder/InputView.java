package src.ladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int inputNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException e) {
            ErrorMessage.NUMBER_FORMAT_EXCCEPTION.getMessage();
            return inputNumber();
        } catch (IOException e) {
            e.printStackTrace();
            return inputNumber();
        }
        return number;
    }


}
