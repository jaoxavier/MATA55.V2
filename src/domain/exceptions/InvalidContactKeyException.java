package domain.exceptions;

public class InvalidContactKeyException extends RuntimeException {
    public InvalidContactKeyException(String message) {
        super(message);
    }
}

