package main.java.medicalconsultation;

import data.HealthCardID;
import data.ProductID;
import main.java.medicalconsultation.exceptions.*;

import java.util.HashMap;
import java.util.Map;

public class MedicalPrescription {

    private HealthCardID cip;
    private String illness;

    private Map<ProductID, TakingGuideline> lines = new HashMap<>();

    public MedicalPrescription(HealthCardID cip, String illness) {
        this.cip = cip;
        this.illness = illness;
    }

    public void addLine(ProductID prodID, String[] instruc)
            throws ProductAlreadyInPrescriptionException,
            IncorrectTakingGuidelinesException {

        if (lines.containsKey(prodID))
            throw new ProductAlreadyInPrescriptionException();

        if (instruc == null || instruc.length < 6)
            throw new IncorrectTakingGuidelinesException();

        try {
            dayMoment dm = dayMoment.valueOf(instruc[0]);
            float duration = Float.parseFloat(instruc[1]);
            float dose = Float.parseFloat(instruc[2]);
            float freq = Float.parseFloat(instruc[3]);
            FqUnit fu = FqUnit.valueOf(instruc[4]);
            String instr = instruc[5];

            if (duration <= 0 || dose <= 0 || freq <= 0)
                throw new IncorrectTakingGuidelinesException();

            TakingGuideline tg =
                    new TakingGuideline(dm, duration, dose, freq, fu, instr);

            lines.put(prodID, tg);

        } catch (Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }
    }

    public void modifyDoseInLine(ProductID prodID, float newDose)
            throws ProductNotInPrescriptionException {

        if (newDose <= 0)
            throw new IllegalArgumentException("Dose must be positive");

        TakingGuideline tg = lines.get(prodID);
        if (tg == null)
            throw new ProductNotInPrescriptionException();

        tg.getPosology().setDose(newDose);
    }

    public void removeLine(ProductID prodID)
            throws ProductNotInPrescriptionException {

        if (!lines.containsKey(prodID))
            throw new ProductNotInPrescriptionException();

        lines.remove(prodID);
    }

    public int getNumberOfLines() {
        return lines.size();
    }
}
