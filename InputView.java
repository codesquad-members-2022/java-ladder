import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputView {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final String REQUEST_PEOPLE_NUMBER = "참여할 사람은 몇 명인가요? \n> ";
	private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요? \n> ";

	int getPeopleNumber() throws IOException {
		System.out.print(REQUEST_PEOPLE_NUMBER);
		int peopleNumber = Integer.parseInt(br.readLine());

		return peopleNumber;
	}

	int getLadderHeight() throws IOException {
		System.out.print(REQUEST_LADDER_HEIGHT);
		int ladderHeight = Integer.parseInt(br.readLine());

		return ladderHeight;
	}
}