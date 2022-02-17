package view;

import java.util.List;

public class OutputView {
	private static final String BLANK = " ";
	public void print(List<List<String>> ladder){
		for(List<String> row : ladder){
			printRow(row);
		}
	}

	private void printRow(List<String> row){
		for(String element : row){
			System.out.print(element);
		}
		System.out.println();
	}

	public void printPlayerName(List<String> nameList){
		for(String name : nameList){
			System.out.print(name);
			System.out.print(BLANK);
		}
		System.out.println();
	}
}
