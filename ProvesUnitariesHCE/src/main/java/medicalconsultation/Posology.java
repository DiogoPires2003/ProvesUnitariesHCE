package medicalconsultation;

public class Posology {

    private float dose;
    private float freq;
    private FqUnit freqUnit;

    public Posology(float dose, float freq, FqUnit freqUnit) {
        if (dose <= 0 || freq <= 0 || freqUnit == null) {
            throw new IllegalArgumentException("Invalid posology parameters");
        }
        this.dose = dose;
        this.freq = freq;
        this.freqUnit = freqUnit;
    }

    public float getDose() {
        return dose;
    }

    public void setDose(float dose) {
        if (dose <= 0)
            throw new IllegalArgumentException();
        this.dose = dose;
    }

    public float getFreq() {
        return freq;
    }

    public void setFreq(float freq) {
        if (freq <= 0)
            throw new IllegalArgumentException();
        this.freq = freq;
    }

    public FqUnit getFreqUnit() {
        return freqUnit;
    }

    public void setFreqUnit(FqUnit freqUnit) {
        if (freqUnit == null)
            throw new IllegalArgumentException();
        this.freqUnit = freqUnit;
    }
}
