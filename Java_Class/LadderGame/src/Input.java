import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private int headCount;
    private int ladderHeight;

    private String receiveInput(Message message) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        String temp = "";
        try {
            while (!isValid((temp = br.readLine()))) {
                System.out.println(Message.NOTNUMBER);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    private boolean isValid(String input) {
        if (input.matches("\\d+")) {
            return true;
        }
        return false;
    }

    protected void processInput() {
        headCount = Integer.parseInt(receiveInput(Message.HEADCOUNT));
        ladderHeight = Integer.parseInt(receiveInput(Message.LADDERHEIGHT));
    }

    protected int[] getInputAsArray() {
        int[] intArr = new int[2];
        intArr[0] = headCount;
        intArr[1] = ladderHeight;
        return intArr;
    }
}
