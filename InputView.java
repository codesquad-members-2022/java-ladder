import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputView {
	// 사람과 사다리 개수를 입력받는 메서드
	private int[] getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("참여할 사람은 몇 명인가요? \n>");
		int peopleNumber = Integer.parseInt(br.readLine());
		System.out.print("최대 사다리 높이는 몇 개인가요? \n>");
		int ladderHeight = Integer.parseInt(br.readLine());

		return new int[] {peopleNumber, ladderHeight};
	}
}