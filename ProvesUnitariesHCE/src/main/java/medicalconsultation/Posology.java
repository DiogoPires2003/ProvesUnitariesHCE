package main.java.medicalconsultation;

public class Posology {

    private float dose;
    private float freq;
    private FqUnit freqUnit;

    public Posology(float dose, float freq, FqUnit freqUnit) {
        this.dose = dose;
        this.freq = freq;
        this.freqUnit = freqUnit;
    }

    public float getDose() {
        return dose;
    }

    public void setDose(float dose) {
        this.dose = dose;
    }

    public float getFreq() {
        return freq;
    }

    public FqUnit getFreqUnit() {
        return freqUnit;
    }
}
