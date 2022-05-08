package dorofeev;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
        super();
    }

    public EmptyStringException(String message) {
        super(message);
    }
}
