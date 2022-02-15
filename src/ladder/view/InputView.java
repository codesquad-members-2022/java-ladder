package ladder.view;

import ladder.system.SystemMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    static Input input = new Input();

    public List<Integer> getWidthAndHeight() throws Exception {
        List<Integer> widthAndHeight = new ArrayList<>();
        System.out.println(SystemMessage.INPUT_COUNT_AND_HEIGHT);

        while (widthAndHeight.size() < 2) {
            int value;
            try {
                value = input.integer();
                widthAndHeight.add(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return widthAndHeight;
    }

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
}
