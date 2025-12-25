package medicalconsultation;

import data.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MedicalPrescription {

    private HealthCardID cip;
    private int memberShipNumb;
    private String illness;
    private ePrescripCode prescCode;
    private Date prescDate;
    private Date endDate;
    private DigitalSignature eSign;

    private Map<ProductID, TakingGuideline> lines = new HashMap<>();

    public MedicalPrescription(HealthCardID cip, int memberShipNumb, String illness) {
        this.cip = cip;
        this.memberShipNumb = memberShipNumb;
        this.illness = illness;
    }

    public void addLine(ProductID prodID, String[] instruc)
            throws ProductAlreadyInPrescriptionException,
            IncorrectTakingGuidelinesException {

        if (lines.containsKey(prodID))
            throw new ProductAlreadyInPrescriptionException();

        try {
            TakingGuideline tg = createTakingGuideline(instruc);
            lines.put(prodID, tg);
        } catch (Exception e) {
            throw new IncorrectTakingGuidelinesException();
        }
    }

    public void modifyDoseInLine(ProductID prodID, float newDose)
            throws ProductNotInPrescriptionException {

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

    public Map<ProductID, TakingGuideline> getLines() {
        return lines;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }


    private TakingGuideline createTakingGuideline(String[] instruc) {

        dayMoment dm = dayMoment.valueOf(instruc[0]);
        float duration = Float.parseFloat(instruc[1]);
        float dose = Float.parseFloat(instruc[2]);
        float freq = Float.parseFloat(instruc[3]);
        FqUnit fu = FqUnit.valueOf(instruc[4]);
        String instructions = instruc.length > 5 ? instruc[5] : null;

        return new TakingGuideline(dm, duration, dose, freq, fu, instructions);
    }
}
