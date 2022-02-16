package main.domain;

import java.util.List;

public enum LadderElement implements LadderOperation {
    VERTICAL("|") {
        @Override
        public boolean check(int col, boolean prev, boolean rand) {
            return col % 2 == 0;
        }

        @Override
        public void change(List<List<LadderElement>> map, int row, int col) {
            map.get(row).set(col, this);
        }

        @Override
        public boolean next(boolean prev) {
            return prev;
        }
    },
    HORIZONTAL("-----") {
        @Override
        public boolean check(int col, boolean prev, boolean rand) {
            return col % 2 != 0 && prev && rand;
        }

        @Override
        public void change(List<List<LadderElement>> map, int row, int col) {
            map.get(row).set(col, this);
        }

        @Override
        public boolean next(boolean prev) {
            return false;
        }
    },
    BLANK("     ") {
        @Override
        public boolean check(int col, boolean prev, boolean rand) {
            return col % 2 != 0 && !prev || !rand;
        }

        @Override
        public void change(List<List<LadderElement>> map, int row, int col) {
            map.get(row).set(col, this);
        }

        @Override
        public boolean next(boolean prev) {
            return true;
        }
    };

    private final String str;

    LadderElement(String str) {
        this.str = str;
    }

    public static int getGap() {
        return HORIZONTAL.get().length();
    }

    public String get() {
        return str;
    }
}
