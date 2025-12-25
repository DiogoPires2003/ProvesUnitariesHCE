package medicalconsultation;

public class TakingGuideline {

    private dayMoment dMoment;
    private float duration;
    private Posology posology;
    private String instructions;

    public TakingGuideline(dayMoment dMoment,
                           float duration,
                           float dose,
                           float freq,
                           FqUnit freqUnit,
                           String instructions) {

        if (dMoment == null || duration <= 0 || freqUnit == null)
            throw new IllegalArgumentException("Invalid taking guideline");

        this.dMoment = dMoment;
        this.duration = duration;
        this.posology = new Posology(dose, freq, freqUnit);
        this.instructions = instructions;
    }

    public dayMoment getDayMoment() {
        return dMoment;
    }

    public void setDayMoment(dayMoment dMoment) {
        this.dMoment = dMoment;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Posology getPosology() {
        return posology;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
