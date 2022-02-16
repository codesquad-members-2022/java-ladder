import java.util.Scanner;

public class UserData {

    private int userCount;

    public void inputUserData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("몇 명의 유저가 참여합니까 ?");
        userCount = sc.nextInt();
    }

    public int getUserCount() {
        return userCount;
    }
}
