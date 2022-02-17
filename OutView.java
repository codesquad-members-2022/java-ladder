import java.util.List;

class OutView {
	private static final String BLANK = " ";
	void print(List<List<String>> ladder){
		for(List<String> row : ladder){
			printRow(row);
		}
	}

	void printRow(List<String> row){
		for(String element : row){
			System.out.print(element);
		}
		System.out.println();
	}

	void printPlayerName(List<String> nameList){
		for(String name : nameList){
			System.out.print(name);
			System.out.print(BLANK);
		}
		System.out.println();
	}
}
