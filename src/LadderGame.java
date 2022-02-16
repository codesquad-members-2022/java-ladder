import java.util.Random;
import java.util.Scanner;

public class LadderGame {

  String[][] ladder;


  public Ladder gameInfo() {
    System.out.println("참여할 사람은 몇 명인가요?");
    int numOfPeople = inputNumber();
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    int heightOfLadder = inputNumber();

    return new Ladder(numOfPeople, heightOfLadder);
  }

  public void makeLadder(Ladder ladder) {
    int numOfPeople = ladder.getNumOfPeople();
    
    int columnOfLadder = numOfPeople * 2 - 1;
    int rowOfLadder = ladder.getHeight();

    this.ladder = new String[rowOfLadder][columnOfLadder];
    for (int row = 0; row < rowOfLadder; row++) {
      for (int colomn = 0; colomn < columnOfLadder; colomn++) {
        this.ladder[row][colomn] = getLadder(colomn);
      }
    }
  }

  private int inputNumber() {
    return new Scanner(System.in).nextInt();
  }


  public void printLadder() {
    for (int i = 0; i < ladder.length; i++) {
      for (int j = 0; j < ladder[i].length; j++) {
        System.out.print(ladder[i][j]);
      }
      System.out.println();
    }
  }

  private String getLadder(int number) {
    if (getRemainder(number) == 0) {
      return getLadderFrame();
    }
    return getLadderLine();
  }

  private int getRemainder(int number) {
    return number % 2;
  }

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
