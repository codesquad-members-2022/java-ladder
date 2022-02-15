public class PrintLadder {

	private static final StringBuilder sb = new StringBuilder();

	private PrintLadder() {}

	public static void printLadder(char[][] ladderFrame, boolean[][] ladderFoothold) {
		for (int i = 0; i < ladderFrame.length; i++) {
			appendString(ladderFrame, ladderFoothold, i);
		}
		System.out.println(sb);
		sb.setLength(0);
	}

	private static void appendString(char[][] ladderFrame, boolean[][] ladderFoothold, int i) {
		for (int j = 0; j < ladderFrame[i].length; j++) {
			if (j == ladderFrame[i].length - 1) {
				sb.append(ladderFrame[i][j]).append("\n");
			} else {
				char tmp = ladderFoothold[i][j] ? '-' : ' ';
				sb.append(ladderFrame[i][j]).append(tmp);
			}
		}
	}

}
