package medicalconsultation;

import data.*;
import services.HealthNationalService;

public class HealthNationalServiceStub implements HealthNationalService {

    @Override
    public MedicalHistory getMedicalHistory(HealthCardID cip) {
        try {
            return new MedicalHistory(cip, 1);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness) {
        return new MedicalPrescription(cip, 1, illness);
    }

    @Override
    public MedicalPrescription sendHistoryAndPrescription(
            HealthCardID cip,
            MedicalHistory hce,
            String illness,
            MedicalPrescription mp) {
        return mp;
    }

    @Override
    public MedicalPrescription generateTreatmCodeAndRegister(
            MedicalPrescription ePresc) {
        return ePresc;
    }
}
