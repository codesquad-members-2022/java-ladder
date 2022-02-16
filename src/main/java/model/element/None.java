package model.element;

public class None implements Element {
    private String str = " ";

    public None(int length) {
        StringBuffer sb = new StringBuffer();
        while (length-- > 0) {
            sb.append(this.str);
        }
        this.str = sb.toString();
    }

    @Override
    public String toString() {
        return str;
    }
}
