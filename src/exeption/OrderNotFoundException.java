package exeption;

/**
 * Exception при липсваща поръчка
 */
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}