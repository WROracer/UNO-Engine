package de.wroracer.unoengine.exeptions;

public class UnoException extends Exception {
    public UnoException() {
        super();
    }

    public UnoException(String message) {
        super(message);
    }

    public UnoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnoException(Throwable cause) {
        super(cause);
    }
}
