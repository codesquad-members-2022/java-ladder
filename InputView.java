import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        public List<String> stringList() throws Exception {
            st = new StringTokenizer(br.readLine(),",");
            List<String> arrayList = new ArrayList<>();
            while (st.hasMoreElements()) {
                arrayList.add(st.nextToken());
            }
            return arrayList;
        }

    }

    public int inputIntValue() {
        int value;
        while (true) {
            try {
                value = input.integer();
                break;
            } catch (Exception e) {
                System.out.println("값을 제대로 입력해주세요.");
            }
        }
        return value;
    }

    //사람이름을 입력받기위한 메서드

    public List<String> inputPeoples() {
        List<String> peoples = new ArrayList<>();
        try {
            peoples = input.stringList();
        } catch (Exception e) {
            System.out.println("값을 제대로 입력해주세요.");
        }
        return peoples;
    }

}
