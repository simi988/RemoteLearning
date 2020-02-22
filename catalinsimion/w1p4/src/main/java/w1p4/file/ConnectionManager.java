package w1p4.file;

import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    private static ConnectionManager connectionManager = null;

    private static List<Connection> connections;


    private ConnectionManager(int maxConnection) {

        connections = new ArrayList<>();

        for (int i = 0; i < maxConnection; i++) {
            connections.add(new Connection());
        }
    }

    public static ConnectionManager getInstance(int maxConnection) {

        if (connectionManager == null) {
            connectionManager = new ConnectionManager(maxConnection);

        }
        return connectionManager;
    }

    public Connection getConnection() {
        if (connections.isEmpty()) {
            return null;
        }

        Connection connection = connections.get(connections.size()-1);
        return connection;

    }



    public class Connection {

        private Connection() {

        }

    }
}
