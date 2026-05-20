package exeption;

/**
 * Exception при липсваща маса
 */
public class TableNotFoundException extends RuntimeException {
    public TableNotFoundException(String message) {
        super(message);
    }
}