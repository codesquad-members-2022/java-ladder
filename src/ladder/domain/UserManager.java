package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    public String allUserRegister;
    public int allUserNumber;
    public List<Integer> nameLengthGroup;

    public UserManager(List<User> userList) {
        StringBuilder sb = new StringBuilder();
        nameLengthGroup = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            sb.append(processUserName(user));
            nameLengthGroup.add(user.name.length());
        }
        allUserRegister = sb.toString();
        allUserNumber = userList.size();
    }

    private String processUserName(User user) {
        String userName = user.name;
        int gapSize = initGapSize(user);
        if (user.nameLimitExcess) {
            userName += "..";
            gapSize -= 2;
        }
        String gapString = initGapString(gapSize);
        return userName + gapString;
    }

    private int initGapSize(User user) {
        if (user.name.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            int korSpacing = user.name.length() / 2;
            return 10 - user.name.length() - korSpacing;
        }
        return 10 - user.name.length() + 1;
    }

    private String initGapString(int gapSize) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gapSize; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
