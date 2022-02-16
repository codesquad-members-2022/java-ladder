package domain;

import java.util.HashMap;
import java.util.Map;

public enum NameFormat {
    ONE {
        @Override
        public String makeForm(String name) {
            return "  " + name + "   ";
        }
    },
    TWO {
        @Override
        public String makeForm(String name) {
            return "  " + name + "  ";
        }
    },
    THREE {
        @Override
        public String makeForm(String name) {
            return " " + name + "  ";
        }
    },
    FOUR {
        @Override
        public String makeForm(String name) {
            return name + "  ";
        }
    },
    FIVE {
        @Override
        public String makeForm(String name) {
            return name + " ";
        }
    };

    private static final Map<Integer, String> nameInfo = new HashMap<>();

    static {
        nameInfo.put(1, "ONE");
        nameInfo.put(2, "TWO");
        nameInfo.put(3, "THREE");
        nameInfo.put(4, "FOUR");
        nameInfo.put(5, "FIVE");
    }

    public static NameFormat getFormatter(int length) {
        return valueOf(nameInfo.get(length));
    }

    public abstract String makeForm(String name);
}
