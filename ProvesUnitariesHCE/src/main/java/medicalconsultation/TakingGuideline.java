package main.java.medicalconsultation;

public class TakingGuideline {

    private dayMoment dayMoment;
    private float duration;
    private Posology posology;
    private String instructions;

    public TakingGuideline(dayMoment dm,
                           float duration,
                           float dose,
                           float freq,
                           FqUnit fu,
                           String instr) {

        this.dayMoment = dm;
        this.duration = duration;
        this.posology = new Posology(dose, freq, fu);
        this.instructions = instr;
    }

    public dayMoment getDayMoment() {
        return dayMoment;
    }

    public float getDuration() {
        return duration;
    }

    public Posology getPosology() {
        return posology;
    }

    public String getInstructions() {
        return instructions;
    }
}
