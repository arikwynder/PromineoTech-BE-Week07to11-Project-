package projects.exception;

/**
 * DbException is a custom unchecked exception that serves as a wrapper for database-related
 * errors, enabling more descriptive error reporting and consistent exception handling.
 *
 * This exception is typically used for encapsulating {@link SQLException} or other database
 * error conditions encountered in database operations.
 *
 * It extends {@link RuntimeException}, making it an unchecked exception that does not
 * require being declared in method signatures.
 *
 * @author Ari Hayhurst
 */
public class DbException extends RuntimeException {

    /**
     * Constructs a new DbException with the specified detail message.
     *
     * @param message the detail message describing the cause of the exception
     */
    public DbException(String message) {
        throw new DbException(message);
    }

    /**
     * Constructs a new DbException by wrapping an existing {@link Throwable} cause.
     *
     * @param cause the underlying exception or error that caused this DbException to be thrown
     */
    public DbException(Throwable cause) {
        throw new DbException(cause);
    }

    /**
     * Constructs a new DbException with the specified detail message and cause.
     *
     * @param message the detail message describing the cause of the exception
     * @param cause the underlying exception or error that caused this DbException to be thrown
     */
    public DbException(String message, Throwable cause) {
        throw new DbException(message, cause);
    }
}
