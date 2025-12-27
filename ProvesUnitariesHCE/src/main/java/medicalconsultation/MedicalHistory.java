package main.java.medicalconsultation;

import data.HealthCardID;
import main.java.medicalconsultation.exceptions.IncorrectParametersException;

public class MedicalHistory {

    private HealthCardID cip;
    private int memberShipNumb;
    private String history = "";

    public MedicalHistory(HealthCardID cip, int memberShipNumb)
            throws IncorrectParametersException {

        if (cip == null || memberShipNumb <= 0)
            throw new IncorrectParametersException("Invalid parameters");

        this.cip = cip;
        this.memberShipNumb = memberShipNumb;
    }

    public void addMedicalHistoryAnnotations(String annot) {
        history += annot + "\n";
    }

    public void setNewDoctor(int mshN) {
        if (mshN > 0)
            this.memberShipNumb = mshN;
    }

    public HealthCardID getCip() {
        return cip;
    }

    public int getMemberShipNumb() {
        return memberShipNumb;
    }

    public String getHistory() {
        return history;
    }
}
