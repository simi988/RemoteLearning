package w11p1.main;

import w11p1.file.Client;
import w11p1.file.Server;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final int NUMBER_OF_CLIENTS = 10;

    public static void main(String[] args) {
        List<String> messages = new LinkedList<>();
        Thread server = new Thread(new Server(messages));
        for (Integer i = 0; i < NUMBER_OF_CLIENTS; i++) {
            Thread client = new Thread(new Client(i.toString(), messages));
            client.start();
        }
        server.start();
    }
}
