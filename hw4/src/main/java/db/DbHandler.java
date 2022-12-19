package db;

import java.sql.Connection;
import java.sql.SQLException;

public class DbHandler {
    private static ConnectionPool connectionPool;

    private DbHandler() {
    }

    static {
        try {
            connectionPool = BasicConnectionPoolImpl.init();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }

    public static boolean releaseConnection(Connection connection) {
        return connectionPool.releaseConnection(connection);
    }
}
