public class Ladder implements Comparable<Ladder> {

  private char ladderFrame;
  private String ladderLine;

  public char getLadderFrame() {
    return ladderFrame;
  }

  public void setLadderFrame(char ladderFrame) {
    this.ladderFrame = ladderFrame;
  }

  public String getLadderLine() {
    return ladderLine;
  }

  public void setLadderLine(String ladderLine) {
    this.ladderLine = ladderLine;
  }

  @Override
  public int compareTo(Ladder o) {
    if (this.ladderLine.equals(o.getLadderLine())) {
      return 0;
    }
    return 1;
  }
}
