package domain.ladder;

import domain.Line;

import java.util.List;

public interface Ladder {
    public int run(int startLine);
    public List<Line> getLines();
    public int getHeight();
}
