package main.java.medicalconsultation.exceptions;

public class ProductAlreadyInPrescriptionException extends Exception {
    public ProductAlreadyInPrescriptionException() {
        super();
    }

    public ProductAlreadyInPrescriptionException(String msg) {
        super(msg);
    }
}
