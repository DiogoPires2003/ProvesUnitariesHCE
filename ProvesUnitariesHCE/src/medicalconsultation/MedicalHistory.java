package medicalconsultation;

import data.HealthCardID;

public class MedicalHistory {

    private HealthCardID cip;
    private int memberShipNumb;
    private String history;

    public MedicalHistory(HealthCardID cip, int memberShipNumb)
            throws IncorrectParametersException {

        if (cip == null || memberShipNumb <= 0)
            throw new IncorrectParametersException();

        this.cip = cip;
        this.memberShipNumb = memberShipNumb;
        this.history = "";
    }

    public void addMedicalHistoryAnnotations(String annot) {
        if (annot != null && !annot.isBlank()) {
            history += annot + "\n";
        }
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
