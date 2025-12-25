package exceptions;

public class ProductNotInPrescriptionException extends Exception {
    public ProductNotInPrescriptionException() {
        super();
    }

    public ProductNotInPrescriptionException(String msg) {
        super(msg);
    }
}
