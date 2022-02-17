package com.sh;

import static com.sh.utils.Input.*;


public class Main {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.run();
        scanClose();
    }
}
