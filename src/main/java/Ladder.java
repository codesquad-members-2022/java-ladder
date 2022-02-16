public class Ladder {
    private String name;

    public Ladder(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5글자가 넘을 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
