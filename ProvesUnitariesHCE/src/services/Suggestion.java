package services;

public class Suggestion {
    private char action; // 'I' for Insertion, 'E' for Elimination, 'M' for Modification
    private String productID;
    private String moment;
    private String duration;
    private String dose;
    private String frequency;
    private String period;
    private String instructions;

    public Suggestion(char action, String productID, String moment, String duration, String dose, String frequency, String period, String instructions) {
        this.action = action;
        this.productID = productID;
        this.moment = moment;
        this.duration = duration;
        this.dose = dose;
        this.frequency = frequency;
        this.period = period;
        this.instructions = instructions;
    }

    public char getAction() {
        return action;
    }

    public String getProductID() {
        return productID;
    }

    public String getMoment() {
        return moment;
    }

    public String getDuration() {
        return duration;
    }

    public String getDose() {
        return dose;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getPeriod() {
        return period;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "services.Suggestion{" +
                "action=" + action +
                ", productID='" + productID + '\'' +
                ", moment='" + moment + '\'' +
                ", duration='" + duration + '\'' +
                ", dose='" + dose + '\'' +
                ", frequency='" + frequency + '\'' +
                ", period='" + period + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
