import java.util.ArrayList;
import java.util.List;

public class Ladders {

  //  private char[][] totalLadders;
  private List<List<Ladder>> totalLadders;
  private int numOfPeople;
  private int numOfcolumns;
  private int height;
  private List<Player> players;

  public Ladders(int numOfPeople, int height) {
    this.numOfPeople = numOfPeople;
    this.height = height;
    this.numOfcolumns = numOfPeople * 2;
//    this.totalLadders = new char[height][this.numOfcolumns];
    this.totalLadders = new ArrayList<>(height); //이렇게 설정해 놓아도 더 많이 add 할 수 있다.
  }

  public Ladders(int numOfPeople, int height, List<Player> players) {
    this.numOfPeople = numOfPeople;
    this.height = height;
    this.numOfcolumns = numOfPeople * 2;
//    this.totalLadders = new char[height][this.numOfcolumns];
    this.totalLadders = new ArrayList<>(height);
    this.players = players;
  }

  public int getNumOfPeople() {
    return numOfPeople;
  }

  public List<List<Ladder>> get() {
    return totalLadders;
  }

  public void setTotalLadders(List<List<Ladder>> totalLadders) {
    this.totalLadders = totalLadders;
  }

  public int getHeight() {
    return height;
  }

  public int getNumOfcolumns() {
    return numOfcolumns;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }
}
