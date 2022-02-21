package main.com.view;

import java.util.List;

import main.com.domain.Ladder;
import main.com.domain.LadderLine;
import main.com.domain.LadderRow;

public class OutputView {
	private static final String BLANK = " ";
	private static final String BUFFER = "  ";

	public void print(Ladder ladder){
		for(LadderRow ladderRow : ladder.ladderForGame){
			printRow(ladderRow.element);
		}
	}

	private void printRow(List<LadderLine> row){
		System.out.print(BUFFER);
		for(LadderLine ladderLine : row){
			System.out.print(ladderLine.element);
		}
		System.out.println();
	}

	public void printPlayerName(String[] nameList){
		for(String name : nameList){
			System.out.print(name);
			System.out.print(BLANK);
		}
		System.out.println();
	}
}
