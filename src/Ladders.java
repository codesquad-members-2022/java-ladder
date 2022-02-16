public class Ladders {

  private char[][] totalLadders;
  private int numOfPeople;
  private int numOfcolumns;
  private int height;

  public Ladders(int numOfPeople, int height) {
    this.numOfPeople = numOfPeople;
    this.height = height;
    this.numOfcolumns = numOfPeople * 2;
    this.totalLadders = new char[height][this.numOfcolumns];
  }

  public int getNumOfPeople() {
    return numOfPeople;
  }

  public char[][] get() {
    return totalLadders;
  }

  public void setTotalLadders(char[][] totalLadders) {
    this.totalLadders = totalLadders;
  }

  public int getHeight() {
    return height;
  }

  public int getNumOfcolumns() {
    return numOfcolumns;
  }
}
