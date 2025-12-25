package data;

final public class ePrescripCode {

    private final String prescCode;

    public ePrescripCode(String prescCode) {
        if (prescCode == null) {
            throw new IllegalArgumentException("El código de prescripción no puede ser nulo.");
        }

        if (prescCode.trim().length() < 5) {
            throw new IllegalArgumentException("El código de prescripción debe tener 5 caracteres de longitud.");
        }

        this.prescCode = prescCode;
    }

    public String getPrescCode() {
        return prescCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ePrescripCode that = (ePrescripCode) o;
        return prescCode.equals(that.prescCode);
    }

    @Override
    public int hashCode() { return prescCode.hashCode(); }

    @Override
    public String toString() {
        return "ePrescripCode{" + "prescCode='" + prescCode + '\'' + '}';
    }
}
