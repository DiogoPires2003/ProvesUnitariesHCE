package exceptions;

public class IncorrectEndingDateException extends Exception {
    public IncorrectEndingDateException() {
        super();
    }

    public IncorrectEndingDateException(String msg) {
        super(msg);
    }
}
