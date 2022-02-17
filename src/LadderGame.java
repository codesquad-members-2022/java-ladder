import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {


  public Ladders gameInfoStep1() {
    System.out.println("참여할 사람은 몇 명인가요?");
    int numOfPeople = inputNumber();
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    int heightOfLadder = inputNumber();

    return new Ladders(numOfPeople, heightOfLadder);
  }

  public Ladders gameInfoStep2() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    Scanner scanner = new Scanner(System.in);
    List<Player> players = getPlayers(scanner.nextLine());

    System.out.println("최대 사다리 높이는 몇 개인가요?");
    int height = scanner.nextInt();
    scanner.close();

    return new Ladders(players.size(), height, players);
  }

  private List<Player> getPlayers(String value) {
    List<Player> players = new ArrayList<>();

    String[] playersArr = splitValue(value);
    for (int i = 0; i < playersArr.length; i++) {
      players.add(new Player(playersArr[i]));
    }
    return players;
  }

  private String[] splitValue(String value) {
    return value.split(",");
  }

  public Ladders makeLadder(Ladders ladders) {
    List<List<Ladder>> totalLadders = new ArrayList<>();
    for (int whatFloor = 0; whatFloor < ladders.getHeight(); whatFloor++) {
      List<Ladder> floorLadder = new ArrayList<>();
      floorLadder = makeOneFloorLadder(whatFloor, ladders.getNumOfcolumns());
      totalLadders.add(floorLadder);
    }
    ladders.setTotalLadders(totalLadders);
    return ladders;
  }

  private List<Ladder> makeOneFloorLadder(int numOfFloor, int numOfColumns) {
    List<Ladder> oneFloor = new ArrayList<>(numOfColumns);

    for (int column = 0; column < numOfColumns - 1; column += 2) {
      oneFloor.add(getLadderShape(column, numOfColumns));
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

  public void printLadder(Ladders ladders) {
    printPlayers(ladders);

    List<List<Ladder>> totalLadder = ladders.get();
    for (int i = 0; i < totalLadder.size(); i++) {
      printOneFloor(totalLadder.get(i));
      System.out.println();
    }
  }

  private void printPlayers(Ladders ladders) {
    for (Player player : ladders.getPlayers()) {
      System.out.print(padRight(player.getName()));
    }
    System.out.println();
  }

  private String padRight(String value) {
    // TODO 퍼옴. 의미를 잘 모르겠음. 이건 나중에.
    return String.format("%-" + 6 + "s", value);
  }

  private void printOneFloor(List<Ladder> oneFloor) {
    for (Ladder ladder : oneFloor) {
      System.out.print(ladder.getLadderFrame());
      System.out.print(ladder.getLadderLine());
    }
  }

  private int inputNumber() {
    return new Scanner(System.in).nextInt();
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
