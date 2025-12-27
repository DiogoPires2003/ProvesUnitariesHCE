package main.java.medicalconsultation.exceptions;

public class AnyCurrentPrescriptionException extends Exception {
    public AnyCurrentPrescriptionException() {
        super();
    }

    public AnyCurrentPrescriptionException(String msg) {
        super(msg);
    }
}
