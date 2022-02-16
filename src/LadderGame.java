import java.util.Random;
import java.util.Scanner;

public class LadderGame {


  public Ladders gameInfo() {
    System.out.println("참여할 사람은 몇 명인가요?");
    int numOfPeople = inputNumber();
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    int heightOfLadder = inputNumber();

    return new Ladders(numOfPeople, heightOfLadder);
  }

  public Ladders makeLadder(Ladders ladders) {
    char[][] totalLadders = ladders.get();
    for (int whatFloor = 0; whatFloor < ladders.get().length; whatFloor++) {
      totalLadders[whatFloor] = makeOneFloorLadder(whatFloor, ladders.getNumOfcolumns());
    }
    ladders.setTotalLadders(totalLadders);
    return ladders;
  }

  public void printLadder(Ladders ladders) {
    char[][] totalLadder = ladders.get();
    for (int i = 0; i < ladders.get().length; i++) {
      printOneFloor(totalLadder[i]);
      System.out.println();
    }
  }

  private void printOneFloor(char[] oneFloor) {
    System.out.print(oneFloor);
  }


  private char[] makeOneFloorLadder(int numOfFloor, int numOfColumns) {
    return getOneFloorLadderShape(numOfColumns);
  }

  private char[] getOneFloorLadderShape(int numOfColumns) {
    char[] oneFloor = new char[numOfColumns];

    for (int column = 0; column < numOfColumns - 1; column += 2) {
      Ladder ladder = getLadderShape(column, numOfColumns);
      oneFloor[column] = ladder.getLadderFrame();
      oneFloor[column + 1] = ladder.getLadderLine();
    }
    return oneFloor;
  }

  private Ladder getLadderShape(int column, int numOfColumns) {
    Ladder ladder = new Ladder();
    ladder.setLadderFrame(LadderShape.LADDER_FRAME);
    if (column == numOfColumns - 2) {
      ladder.setLadderLine(LadderShape.LADDER_LINE_NOEXIST);
      return ladder;
    }

    ladder.setLadderLine(getLadderLine());
    return ladder;
  }

  private int inputNumber() {
    return new Scanner(System.in).nextInt();
  }


  private char getLadderLine() {
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
