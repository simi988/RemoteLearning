import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    private static ConnectionManager connectionManager = null;
    public static final int POSITION = 0;
    private List<Connection> connections;

    private ConnectionManager() {
        connections = new ArrayList<>();
        connections.add(new Connection());
        connections.add(new Connection());
        connections.add(new Connection());
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();

        }
        return connectionManager;
    }

    public Connection getConnection() {
        if (connections.isEmpty()) {
            return null;
        }

        Connection connection = connections.get(POSITION);
        connections.remove(POSITION);
        return connection;
    }
}
