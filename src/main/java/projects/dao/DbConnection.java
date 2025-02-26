package projects.dao;

import projects.exception.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DbConnection class provides a mechanism to establish a connection
 * to a MySQL database using the JDBC driver. It constructs a database
 * connection URI based on predefined configuration parameters such as
 * HOST, PORT, SCHEMA, USER, and PASSWORD.
 *
 * This class simplifies database connection handling by encapsulating
 * the connection logic and appropriately handling SQL exceptions
 * by wrapping them in a custom runtime exception, DbException.
 *
 * @author Ari Hayhurst
 */
public class DbConnection {

    // Declaring variables to build connection URI from
    private static String HOST = "localhost";
    private static String PASSWORD = "promineo";
    private static int PORT = 3306;
    private static String SCHEMA = "projects";
    private static String USER = "projects";

    /**
     * Establishes a connection to the MySQL database using the JDBC driver and predefined connection parameters.
     * If the connection attempt fails, the method throws a DbException wrapping the underlying SQLException.
     *
     * @return a Connection object representing the established database connection
     * @throws DbException if the connection to the database cannot be established
     */
    public static Connection getConnection() {
        // Format a string link to receive connection from
        String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", HOST, PORT, SCHEMA, USER, PASSWORD);

        // Declare a connection variable to store the connection data
        Connection connection;

        // Try block to get connection
        try {
            connection = DriverManager.getConnection(uri, USER, PASSWORD);
            System.out.println("Connection to '" + uri + "' was successful...");
        } catch (SQLException e) { // Catching exception if connection is not made
            System.err.println("[ERROR: SQLException] Connection to '" + uri + "' was unsuccessful...");
            throw new DbException(e);
        }
        // Return connection
        return connection;
    }

}
