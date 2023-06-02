package de.wroracer.uno.engine.error;

public class UnoError extends Error {
    public UnoError(String message) {
        super(message);
    }

    public UnoError(String message, Throwable cause) {
        super(message, cause);
    }

    public UnoError(Throwable cause) {
        super(cause);
    }

}
