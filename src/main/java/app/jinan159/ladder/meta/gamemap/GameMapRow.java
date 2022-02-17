package app.jinan159.ladder.meta.gamemap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class GameMapRow implements Iterable<GameMapColumn> {
    
    private final List<GameMapColumn> columns;

    public GameMapRow(int columnCount) {
        this.columns = new ArrayList<>(columnCount);
    }
    
    public void addColumn(int index, GameMapColumn column) {
        columns.add(index, column);
    }
    
    public Optional<GameMapColumn> getColumn(int index) {
        try {
            return Optional.of(columns.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    @Override
    public Iterator<GameMapColumn> iterator() {
        return new GameMapRowIterator();
    }

    private class GameMapRowIterator implements Iterator<GameMapColumn> {

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            try {
                return columns.size() > nextIndex;
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }

        @Override
        public GameMapColumn next() {
            GameMapColumn column = columns.get(nextIndex);
            nextIndex++;

            return column;
        }
    }
}
