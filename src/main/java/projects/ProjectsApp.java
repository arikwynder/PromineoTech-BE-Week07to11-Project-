package projects;

import projects.exception.DbException;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * The ProjectsApp class is the entry point to the application.
 * It establishes a connection to the database using the DbConnection class.
 * @author Ari Hayhurst
 */
public class ProjectsApp {

    //@formatter:off
    List<String> operations = List.of(
            "1) Add a project"
    );
    //@formatter:on

    private Scanner scanner = new Scanner(System.in);


    /**
     * The main method serves as the entry point for the ProjectsApp application.
     * It initializes the application and begins the processing of user selections.
     *
     * @param args command-line arguments passed to the application (not used in this implementation)
     */
    public static void main(String[] args) {
        new ProjectsApp().processUserSelections();

    }

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
    }

    private Integer getIntInput(String prompt) {
        String input = getStringInput(prompt);
        if(Objects.isNull(input)) {
            return null;
        }
        try {
            return Integer.valueOf(input);
        }
        catch(NumberFormatException e) {
            throw new DbException(input + "is not a valid number. Try again.");
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt + ": ");
        String input = scanner.nextLine();


        return input.isEmpty() ? null : input. trim();
    }
}

