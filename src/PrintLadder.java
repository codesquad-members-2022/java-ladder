public class PrintLadder {

	private static final StringBuilder sb = new StringBuilder();

	private PrintLadder() {}

	public static void printLadder(char[][] ladderFrame, boolean[][] ladderFoothold) {
		for (int i = 0; i < ladderFrame.length; i++) {
			appendStringByLine(ladderFrame, ladderFoothold, i);
		}
		System.out.println(sb);
		sb.setLength(0);
	}

	private static void appendStringByLine(char[][] ladderFrame, boolean[][] ladderFoothold, int i) {
		for (int j = 0; j < ladderFrame[i].length; j++) {
			appendString(ladderFrame, ladderFoothold, i, j);
		}
	}

	private static void appendString(char[][] ladderFrame, boolean[][] ladderFoothold, int i, int j) {
		
		if (j == ladderFrame[i].length - 1) {
			sb.append(ladderFrame[i][j]).append("\n");
			return;
		}
		sb.append(ladderFrame[i][j]).append(ladderFoothold[i][j] ? '-' : ' ');
		
	}

}
