package exeption;

/**
 * Exception при липсващ артикул
 */
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}