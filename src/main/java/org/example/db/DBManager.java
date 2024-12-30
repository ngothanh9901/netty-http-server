package org.example.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private HikariConnPool pool;
    public DBManager(){
        pool = HikariConnPool.getConnPool();
    }
    public void initialiseDB(){
        Connection conn = pool.getConnection();
        try {
            createConnectionInfoTable(conn);
            createRedirectInfoTable(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void createConnectionInfoTable(Connection conn) throws SQLException {
        String createTableSQL = ""
                + "CREATE TABLE IF NOT EXISTS CONNECTIONS( "
                + "ID_CONNECTION INT PRIMARY KEY AUTO_INCREMENT, "
                + "SRC_IP VARCHAR(50) NOT NULL, "
                + "URI VARCHAR(50) NOT NULL, "
                + "TIME_STAMP DECIMAL NOT NULL, "
                + "SEND_B DECIMAL NOT NULL, "
                + "RECEIVED_B DECIMAL NOT NULL, "
                + "SPEED DECIMAL NOT NULL) ;";
        createTable(conn, createTableSQL);
    }
    private void createRedirectInfoTable(Connection conn) throws SQLException {
        String createTableSQL = ""
                + "CREATE TABLE IF NOT EXISTS REDIRECT("
                + "ID_REDIRECT INT PRIMARY KEY AUTO_INCREMENT, "
                + "URL VARCHAR(50) NOT NULL, "
                + "R_COUNT INT NOT NULL);";
        createTable(conn, createTableSQL);
    }
    private void createTable(Connection conn, String sqlQuery) throws SQLException {
        conn.createStatement().executeUpdate(sqlQuery);
    }
}
