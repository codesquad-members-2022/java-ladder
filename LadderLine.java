import java.util.Random;

class LadderLine {
	String makeLadderLine(int column){
		Random random = new Random();

		if(column % 2 == 0){
			return "|";
		}

		if(random.nextBoolean()){
			return "-";
		}

		return " ";

	}
}
