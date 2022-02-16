import java.util.Random;
import java.util.Scanner;

public class LadderGame {

  private String[][] ladders;

  public Ladder gameInfo() {
    System.out.println("참여할 사람은 몇 명인가요?");
    int numOfPeople = inputNumber();
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    int heightOfLadder = inputNumber();

    return new Ladder(numOfPeople, heightOfLadder);
  }

  public String[][] makeLadder(Ladder ladder) {
    initLadders(ladder);

    for (int whatFloor = 0; whatFloor < ladders.length; whatFloor++) {
      ladders[whatFloor] = makeOneFloorLadder(whatFloor, ladder.getNumOfcolumns());
    }
    return ladders;
  }

  private void initLadders(Ladder ladder) {
    ladders = new String[ladder.getHeight()][ladder.getNumOfcolumns()];
  }

  private String[] makeOneFloorLadder(int numOfFloor, int numOfColumns) {
    return getOneFloorLadderShape(numOfColumns);
  }

  private int getRemainder(int number) {
    return number % 2;
  }

  private String[] getOneFloorLadderShape(int numOfColumns) {
    String[] oneFloor = new String[numOfColumns];

    for (int column = 0; column < numOfColumns; column++) {
      if (getRemainder(column) == 0) {
        oneFloor[column] = getLadderFrame();
        continue;
      }
      oneFloor[column] = getLadderLine();
    }
    return oneFloor;
  }

  private int inputNumber() {
    return new Scanner(System.in).nextInt();
  }


  public void printLadder() {
    for (int i = 0; i < ladders.length; i++) {
      for (int j = 0; j < ladders[i].length; j++) {
        System.out.print(ladders[i][j]);
      }
      System.out.println();
    }
  }

//  private String getLadderShape(int column) {
//    if (getRemainder(column) == 0) {
//      return getLadderFrame();
//    }
//    return getLadderLine();
//  }


  private String getLadderLine() {
    boolean isLineExist = isExist(randomNumber());
    if (isLineExist) {
      return "-";
    }
    return " ";
  }

  private String getLadderFrame() {
    return "|";
  }

  private int randomNumber() {
    Random random = new Random();
    return random.nextInt(2);
  }

  private boolean isExist(int number) {
    if (number == 0) {
      return false;
    }
    return true;
  }


}
