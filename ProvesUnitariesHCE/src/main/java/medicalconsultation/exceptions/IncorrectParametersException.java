package exceptions;

public class IncorrectParametersException extends Exception {
    public IncorrectParametersException() {
        super();
    }

    public IncorrectParametersException(String msg) {
        super(msg);
    }
}
