package services;

import medicalConsultation.*;
import services.execeptions.*;

public class HealthNationalServiceMock implements HealthNationalService {

    private boolean connectionError = false;

    public void setConnectionError(boolean connectionError) {
        this.connectionError = connectionError;
    }

    @Override
    public MedicalHistory getMedicalHistory(HealthCardID cip) throws ConnectException, HealthCardIDException {
        if (connectionError) {
            throw new ConnectException("Connection error");
        }
        if (cip == null || cip.isEmpty()) {
            throw new HealthCardIDException("CIP is null or empty");
        }
        return new MedicalHistory();
    }

    @Override
    public MedicalPrescription getMedicalPrescription(HealthCardID cip, String illness) throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException {
        if (connectionError) {
            throw new ConnectException("Connection error");
        }
        if (cip == null || cip.isEmpty()) {
            throw new HealthCardIDException("CIP is null or empty");
        }
        if (illness == null || illness.isEmpty()) {
            throw new AnyCurrentPrescriptionException("No prescription currently for illness: " + illness);
        }
        return new MedicalPrescription();
    }

    @Override
    public MedicalPrescription sendHistoryAndPrescription(HealthCardID cip, History hce, String illness, MedicalPrescription mPresc) throws ConnectException, HealthCardIDException, AnyCurrentPrescriptionException, NotCompletedMedicalPrescription {
        if (connectionError) {
            throw new ConnectException("Connection error");
        }
        if (cip == null || cip.isEmpty()) {
            throw new HealthCardIDException("CIP is null or empty");
        }
        if (illness == null || illness.isEmpty()) {
            throw new AnyCurrentPrescriptionException("No prescription currently for illness: " + illness);
        }
        if (hce == null || mPresc == null) {
            throw new NotCompletedMedicalPrescription("Medical prescription or history is incomplete");
        }
        return mPresc;
    }

    @Override
    public MedicalPrescription generateTreatmCodeAndRegister(MedicalPrescription ePresc) throws ConnectException {
        if (connectionError) {
            throw new ConnectException("Connection error");
        }
        return ePresc;
    }
}
