package view;

public class OutputView {
    private static OutputView ov;

    private OutputView() {}

    public static OutputView getInstance() {
        if (ov == null) {
            ov = new OutputView();
        }
        return ov;
    }
}
