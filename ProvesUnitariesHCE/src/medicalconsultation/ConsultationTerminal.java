package medicalconsultation;

import data.*;
import services.*;

import java.util.Date;

public class ConsultationTerminal {

    private HealthNationalService hns;
    private DecisionMakingAI ai;

    private MedicalHistory history;
    private MedicalPrescription prescription;

    private boolean revisionStarted = false;
    private boolean editingPrescription = false;
    private boolean signed = false;

    public ConsultationTerminal() {}

    public void setHealthNationalService(HealthNationalService hns) {
        this.hns = hns;
    }

    public void setDecisionMakingAI(DecisionMakingAI ai) {
        this.ai = ai;
    }

    public void initRevision(HealthCardID cip, String illness)
            throws Exception {

        history = hns.getMedicalHistory(cip);
        prescription = hns.getMedicalPrescription(cip, illness);
        revisionStarted = true;
    }

    public void enterMedicalAssessmentInHistory(String assess) {
        history.addMedicalHistoryAnnotations(assess);
    }

    public void initMedicalPrescriptionEdition() {
        editingPrescription = true;
    }

    public void enterMedicineWithGuidelines(ProductID prodID, String[] instruc)
            throws Exception {

        prescription.addLine(prodID, instruc);
    }

    public void modifyDoseInLine(ProductID prodID, float newDose)
            throws Exception {

        prescription.modifyDoseInLine(prodID, newDose);
    }

    public void removeLine(ProductID prodID)
            throws Exception {

        prescription.removeLine(prodID);
    }

    public void enterTreatmentEndingDate(Date date) {
        prescription.setEndDate(date);
    }
}
