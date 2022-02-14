package com.sh;

import static com.sh.utils.Input.*;

public class Main {
    public static void main(String[] args) {
        int numberOfPeoples = getNumbers();
        int height = getHeight(numberOfPeoples);

        System.out.println(numberOfPeoples+" : "+height);
    }
}
