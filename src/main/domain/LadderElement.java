package main.domain;

import java.util.List;

public enum LadderElement implements LadderOperation {
    VERTICAL("|") {
        @Override
        public boolean check(int col, boolean next, boolean rand) {
            return col % 2 == 0;
        }

        @Override
        public boolean getNext(boolean prev) {
            return prev;
        }
    },
    HORIZONTAL("-----") {
        @Override
        public boolean check(int col, boolean next, boolean rand) {
            return col % 2 != 0 && next && rand;
        }

        @Override
        public boolean getNext(boolean prev) {
            return false;
        }
    },
    BLANK("     ") {
        @Override
        public boolean check(int col, boolean next, boolean rand) {
            return col % 2 != 0 && (!next || !rand);
        }

        @Override
        public boolean getNext(boolean prev) {
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
