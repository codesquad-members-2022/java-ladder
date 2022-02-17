package view.output;

public class OutputViewImpl implements OutputView {

    private static final OutputViewImpl instance = new OutputViewImpl();

    private OutputViewImpl() {}

    public static OutputView getInstance() {
        return instance;
    }

    @Override
    public void printResultMap(String resultMap) {
        System.out.println("\n--------- 실행결과 ---------\n");
        System.out.println(resultMap);
        System.out.print("\n--------------------------");
    }

}
