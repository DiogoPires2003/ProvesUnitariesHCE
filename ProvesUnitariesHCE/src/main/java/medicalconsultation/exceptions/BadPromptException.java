package main.java.medicalconsultation.exceptions;

public class BadPromptException extends Exception {
    public BadPromptException() {
        super();
    }

    public BadPromptException(String msg) {
        super(msg);
    }
}
