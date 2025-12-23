package services.execeptions;

public class NotCompletedMedicalPrescription extends RuntimeException {
    public NotCompletedMedicalPrescription(String message) {
        super(message);
    }
}
