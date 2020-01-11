package w1p4.main;

import w1p4.file.ConnectionManager;

public class Main {
    public static final int MAX_CONNECTION = 5;

    public static void main(String[] args) {
        ConnectionManager client = ConnectionManager.getInstance(MAX_CONNECTION);

        for (int i = 0; i < 10; i++) {
            ConnectionManager.Connection connection = client.getConnection();
            System.out.println(connection);
        }
    }
}
