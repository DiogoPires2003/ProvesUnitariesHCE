package main.java.medicalconsultation.exceptions;

public class NotCompletedMedicalPrescription extends Exception {
    public NotCompletedMedicalPrescription() {
        super();
    }

    public NotCompletedMedicalPrescription(String msg) {
        super(msg);
    }
}
