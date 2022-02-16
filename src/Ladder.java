public class Ladder {

  private int numOfPeople;
  private int numOfcolumns;
  private int height;

  public Ladder(int numOfPeople, int height) {
    this.numOfPeople = numOfPeople;
    this.height = height;
    this.numOfcolumns = numOfPeople * 2 - 1;
  }

  public int getNumOfPeople() {
    return numOfPeople;
  }

  public int getHeight() {
    return height;
  }

  public int getNumOfcolumns() {
    return numOfcolumns;
  }
}
