package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPoolImpl implements ConnectionPool {
    private static final String CON_STR = "jdbc:sqlite:products.s3db";

    private static final int INITIAL_POOL_SIZE = 10;
    private List<Connection> usedConnections = new ArrayList<>();
    private List<Connection> connectionPool;

    public static BasicConnectionPoolImpl init() throws SQLException, ClassNotFoundException {
        // Регистрируем драйвер, с которым будем работать
        Class.forName("org.sqlite.JDBC");
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(DriverManager.getConnection(CON_STR));
        }
        return new BasicConnectionPoolImpl(pool);
    }

    private BasicConnectionPoolImpl() {
    }

    private BasicConnectionPoolImpl(List<Connection> connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connectionPool.size() == 0) {
            connectionPool.add(DriverManager.getConnection(CON_STR));
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

}
