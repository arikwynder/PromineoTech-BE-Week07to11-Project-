package projects;

import projects.dao.DbConnection;
import projects.exception.DbException;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * The ProjectsApp class is the entry point to the application.
 * It establishes a connection to the database using the DbConnection class.
 * @author Ari Hayhurst
 */
public class ProjectsApp {

    private Scanner scanner = new Scanner(System.in);
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

    //@formatter:off
    private List<String> operations = List.of(
            "1) Add a project"
    );
    //@formatter:on



    private void processUserSelections() {
        boolean done = false;

        while (!done) {
            try {
                int selection = getUserSelection();
            } catch (Exception e) {
                System.out.println("\n[ERROR] " + e + "Try again.");
            }
        }
    }

    private int getUserSelection() {
        printOperations();

        Integer input = getIntInput("Enter a menu selection: ");

        return Objects.isNull(input) ? -1 : input;
    }

    private void printOperations() {
        System.out.println("\nThese are the available selections. Press the Enter key to quit:");
        operations.forEach(System.out::println);
    }

    private Integer getIntInput(String prompt) {
        String input = getStringInput(prompt);
        if(Objects. isNull(input)) {
            return null;
        }
        try {
            return Integer.valueOf(input);
        }
        catch(NumberFormatException e) {
            throw new DbException(input + "is not a valid number.");
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        String input = scanner.nextLine();

        return input.isBlank() ? null : input. trim();
    }
}

