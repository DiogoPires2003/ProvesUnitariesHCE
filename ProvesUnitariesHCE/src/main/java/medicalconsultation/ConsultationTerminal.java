package main.java.medicalconsultation;

import data.HealthCardID;
import data.ProductID;
import main.java.medicalconsultation.exceptions.*;
import services.HealthNationalService;

import java.util.Date;

public class ConsultationTerminal {

    private HealthNationalService hns;

    private MedicalHistory medicalHistory;
    private MedicalPrescription medicalPrescription;

    private boolean revisionStarted = false;
    private boolean editingPrescription = false;

    // Dependency injection
    public void setHealthNationalService(HealthNationalService hns) {
        this.hns = hns;
    }

    // Getter needed for tests
    public boolean isRevisionStarted() {
        return revisionStarted;
    }

    // ───────────────── Input events ─────────────────

    public void initRevision(HealthCardID cip, String illness)
            throws HealthCardIDException, AnyCurrentPrescriptionException {

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
            throws ProceduralException,
            ProductAlreadyInPrescriptionException,
            IncorrectTakingGuidelinesException {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        medicalPrescription.addLine(prodID, instruc);
    }

    public void modifyDoseInLine(ProductID prodID, float newDose)
            throws ProceduralException,
            ProductNotInPrescriptionException {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        medicalPrescription.modifyDoseInLine(prodID, newDose);
    }

    public void removeLine(ProductID prodID)
            throws ProceduralException,
            ProductNotInPrescriptionException {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        medicalPrescription.removeLine(prodID);
    }

    public void enterTreatmentEndingDate(Date date)
            throws ProceduralException, IncorrectEndingDateException {

        if (!editingPrescription)
            throw new ProceduralException("Prescription edition not started");

        if (date.before(new Date()))
            throw new IncorrectEndingDateException();
        // Date is validated but not stored here (per enunciat)
    }
}
