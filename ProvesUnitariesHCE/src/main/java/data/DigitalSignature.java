package data;

import java.util.Arrays;

final public class DigitalSignature {

    private final byte[] signature;

    public DigitalSignature(byte[] signature) {
        if (signature == null) {
            throw new IllegalArgumentException("La firma digital no puede ser nula.");
        }
        if (signature.length == 0) {
            throw new IllegalArgumentException("La firma digital no puede estar vacia.");
        }

        this.signature = signature;
    }

    public byte[] getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature that = (DigitalSignature) o;
        return Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() { return Arrays.hashCode(signature); }

    @Override
    public String toString() {
        return "DigitalSignature{" + "size=" + signature.length + ", hash=" + Arrays.hashCode(signature) + '}';
    }
}