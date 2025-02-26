package projects;

import projects.dao.DbConnection;

import java.sql.Connection;

/**
 * The ProjectsApp class is the entry point to the application.
 * It establishes a connection to the database using the DbConnection class.
 * @author Ari Hayhurst
 */
public class ProjectsApp {

    /**
     * The main method serves as the entry point to the ProjectsApp application.
     * It initializes a connection to the database by invoking the DbConnection.getConnection() method.
     *
     * @param args Command-line arguments passed to the application. These are not used in this implementation.
     */
    public static void main(String[] args) {
        //Get connection
        Connection connection = DbConnection.getConnection();
    }
    
}
