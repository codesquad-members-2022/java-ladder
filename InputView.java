import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class InputView {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final String REQUEST_PLAYER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분) \n> ";
	private static final String REQUEST_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요? \n> ";


	List<String> getPlayerName() throws IOException {
		System.out.print(REQUEST_PLAYER_NAME);
		String[] names = br.readLine().replace(" ", "").split(",");
		NameEditor nameEditor = new NameEditor();
		List<String> nameList = nameEditor.makeList(names);

		return nameList;
	}

	int getLadderHeight() throws IOException {
		System.out.print(REQUEST_LADDER_HEIGHT);
		int ladderHeight = Integer.parseInt(br.readLine());

		return ladderHeight;
	}
}