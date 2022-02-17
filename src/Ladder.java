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
    if (this.ladderLine.equals(LadderShape.LADDER_LINE_EXIST) && o.ladderLine.equals(
        LadderShape.LADDER_LINE_EXIST)) {
      return 0;
    }
    return 1;
  }
}
