package com.sh;

import static com.sh.views.Input.*;

import com.sh.configs.Server;

public class Main {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        server.run();
        scanClose();
    }
}
