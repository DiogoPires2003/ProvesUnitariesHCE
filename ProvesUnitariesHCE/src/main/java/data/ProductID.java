package data;

final public class ProductID {

    private final String upcCode;

    public ProductID(String upcCode) {
        if (upcCode == null) {
            throw new IllegalArgumentException("El código UPC no puede ser nulo.");
        }
        if (upcCode.trim().isEmpty()) {
            throw new IllegalArgumentException("El código UPC no puede estar vacio.");
        }

        this.upcCode = upcCode;
    }

    public String getUpcCode() {
        return upcCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductID productID = (ProductID) o;
        return upcCode.equals(productID.upcCode);
    }

    @Override
    public int hashCode() { return upcCode.hashCode(); }

    @Override
    public String toString() {
        return "ProductID{" + "upcCode='" + upcCode + '\'' + '}';
    }
}
