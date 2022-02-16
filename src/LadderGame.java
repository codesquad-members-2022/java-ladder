import java.util.Random;
import java.util.Scanner;

public class LadderGame {

  private String[][] ladders;

  public Ladders gameInfo() {
    System.out.println("참여할 사람은 몇 명인가요?");
    int numOfPeople = inputNumber();
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    int heightOfLadder = inputNumber();

    return new Ladders(numOfPeople, heightOfLadder);
  }

  public String[][] makeLadder(Ladders ladder) {
    initLadders(ladder);

    for (int whatFloor = 0; whatFloor < ladders.length; whatFloor++) {
      ladders[whatFloor] = makeOneFloorLadder(whatFloor, ladder.getNumOfcolumns());
    }
    return ladders;
  }

  private void initLadders(Ladders ladder) {
    ladders = new String[ladder.getHeight()][ladder.getNumOfcolumns()];
  }

  private String[] makeOneFloorLadder(int numOfFloor, int numOfColumns) {
    return getOneFloorLadderShape(numOfColumns);
  }


  private String[] getOneFloorLadderShape(int numOfColumns) {
    String[] oneFloor = new String[numOfColumns];

    for (int column = 0; column < numOfColumns - 1; column += 2) {
      Ladder ladder = getLadderShape(column, numOfColumns);
      oneFloor[column] = ladder.getLadderFrame();
      oneFloor[column + 1] = ladder.getLadderline();
    }
    return oneFloor;
  }

  private Ladder getLadderShape(int column, int numOfColumns) {
    Ladder ladder = new Ladder();
    ladder.setLadderFrame(LadderShape.LADDER_FRAME);
    if (column == numOfColumns - 2) {
      ladder.setLadderline(LadderShape.LADDER_LINE_NOEXIST);
      return ladder;
    }

    ladder.setLadderline(getLadderLine());
    return ladder;
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

  private String getLadderLine() {
    boolean isLineExist = isExist(randomNumber());
    if (isLineExist) {
      return LadderShape.LADDER_LINE_EXIST;
    }
    return LadderShape.LADDER_LINE_NOEXIST;
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
