import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputView {
    static Input input = new Input();

    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public int integer() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public String next() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public char[] nToCharArray() throws Exception {
            if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken().toCharArray();
        }
    }
    public int inputIntValue() {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(input.br.readLine().toLowerCase());
//                validateStageNumber(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("값을 제대로 입력해주세요.");
            } catch (Exception e) {

            }
        }
        return value;
    }

    private void validateStageNumber(int stageNumber) {
        if (stageNumber <= 0 || stageNumber > 4) {
//            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_VALUE.toString());
        }
    }
}
