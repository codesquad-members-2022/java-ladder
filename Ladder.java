import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder extends ShapeInitializer{
    private List<LadderRow> ladderRows;
    private List<NameTag> nametags;
    private int numberOfPlayer;

    public Ladder(String[] names, int ladderDepth) {
        this.ladderRows = new ArrayList<>();
        this.nametags = new ArrayList<>();
        this.numberOfPlayer = names.length;

        Arrays.stream(names)
                .forEach(name -> nametags.add(new NameTag(name)));

        IntStream.range(0, ladderDepth)
                .forEach(row -> ladderRows.add(new LadderRow(numberOfPlayer * 2 - 1)));
    }

    public ArrayList<NameTag> getNameTags() {
        return (ArrayList<NameTag>) nametags;
    }

    public ArrayList<LadderRow> getLadderRows() {
        return (ArrayList<LadderRow>) ladderRows;
    }
}
