package exception;

public class GlobalSystemException extends RuntimeException {

    public GlobalSystemException(String message) {
        super(message);
    }

    public GlobalSystemException() {
    }
}
