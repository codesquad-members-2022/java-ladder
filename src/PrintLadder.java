public class PrintLadder {

	private PrintLadder() {}

	public static void printLadder(char[][] ladderFrame, boolean[][] ladderfoothold) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ladderFrame.length; i++) {
			for (int j = 0; j < ladderFrame[i].length; j++) {

				if (j == ladderFrame[i].length - 1) {
					sb.append(ladderFrame[i][j]);
					continue;
				}

				char tmp = ladderfoothold[i][j] ? '-' : ' ';
				sb.append(ladderFrame[i][j]).append(tmp);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sb.setLength(0);
	}

}
