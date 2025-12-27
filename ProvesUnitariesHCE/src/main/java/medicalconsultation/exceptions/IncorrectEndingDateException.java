package main.java.medicalconsultation.exceptions;

public class IncorrectEndingDateException extends Exception {
    public IncorrectEndingDateException() {
        super();
    }

    public IncorrectEndingDateException(String msg) {
        super(msg);
    }
}
