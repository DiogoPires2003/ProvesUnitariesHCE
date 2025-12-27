package main.java.medicalconsultation;

import data.HealthCardID;
import data.ProductID;
import services.HealthNationalService;

import java.util.Date;

public class ConsultationTerminal {

    private HealthNationalService hns;

    private MedicalHistory medicalHistory;
    private MedicalPrescription medicalPrescription;

    private boolean revisionStarted = false;
    private boolean editingPrescription = false;

    public void setHealthNationalService(HealthNationalService hns) {
        this.hns = hns;
    }

    public boolean isRevisionStarted() {
        return revisionStarted;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public MedicalPrescription getMedicalPrescription() {
        return medicalPrescription;
    }

    public void initRevision(HealthCardID cip, String illness)
            throws Exception {

        medicalHistory = hns.getMedicalHistory(cip);
        medicalPrescription = hns.getMedicalPrescription(cip, illness);
        revisionStarted = true;
    }

    public void enterMedicalAssessmentInHistory(String assess)
            throws ProceduralException {

        if (!revisionStarted)
            throw new ProceduralException("Revision not started");

        medicalHistory.addMedicalHistoryAnnotations(assess);
    }

    public void initMedicalPrescriptionEdition()
            throws ProceduralException {

        if (!revisionStarted)
            throw new ProceduralException("Revision not started");

        editingPrescription = true;
    }

    public void enterMedicineWithGuidelines(ProductID prodID, String[] instruc)
            throws Exception {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        medicalPrescription.addLine(prodID, instruc);
    }

    public void modifyDoseInLine(ProductID prodID, float newDose)
            throws Exception {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        medicalPrescription.modifyDoseInLine(prodID, newDose);
    }

    public void removeLine(ProductID prodID)
            throws Exception {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        medicalPrescription.removeLine(prodID);
    }

    public void enterTreatmentEndingDate(Date date)
            throws ProceduralException {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        medicalPrescription.setEndDate(date);
    }
}
