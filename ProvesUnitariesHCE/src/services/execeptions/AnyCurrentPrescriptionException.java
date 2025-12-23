package services.execeptions;

public class AnyCurrentPrescriptionException extends RuntimeException {
    public AnyCurrentPrescriptionException(String message) {
        super(message);
    }
}
