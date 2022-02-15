public class GameApplication {

    public GameApplication() {
        init();
    }

    private void init() {
        AppConfig ac = AppConfig.getInstance();
    }

    public void run() {
        System.out.println("Hello, World!");
        System.out.println("Bye, World!");
    }
}
