package data.test;

import data.DigitalSignature;
import data.HealthCardID;
import data.ProductID;
import data.ePrescripCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataPackageTest {

    // TESTS HealthCardID
    @Test
    void testHealthCardID_Valid() {
        String validCode = "REBSBBBBBEAD1234";
        HealthCardID h1 = new HealthCardID(validCode);
        HealthCardID h2 = new HealthCardID(validCode);

        assertEquals(validCode, h1.getPersonalID());
        assertEquals(h1, h2, "Dos HealthCardID con el mismo código deben ser iguales");
        assertEquals(h1.hashCode(), h2.hashCode(), "El hashCode debe coincidir");
        assertTrue(h1.toString().contains(validCode));
    }

    @Test
    void testHealthCardID_Invalid() {
        assertThrows(IllegalArgumentException.class, () -> new HealthCardID(null));
        assertThrows(IllegalArgumentException.class, () -> new HealthCardID(""));
        assertThrows(IllegalArgumentException.class, () -> new HealthCardID("CORTO"));
    }

    // TESTS ProductID
    @Test
    void testProductID_Valid() {
        ProductID p1 = new ProductID("123456789");
        ProductID p2 = new ProductID("123456789");

        assertEquals(p1.getUpcCode(), "123456789");
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testProductID_Invalid() {
        assertThrows(IllegalArgumentException.class, () -> new ProductID(null));
        assertThrows(IllegalArgumentException.class, () -> new ProductID(""));
    }

    // TESTS ePrescripCode
    @Test
    void testEPrescripCode_Valid() {
        ePrescripCode e1 = new ePrescripCode("RX-001");
        ePrescripCode e2 = new ePrescripCode("RX-001");

        assertEquals("RX-001", e1.getPrescCode());
        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void testEPrescripCode_Invalid() {
        assertThrows(IllegalArgumentException.class, () -> new ePrescripCode(null));
        assertThrows(IllegalArgumentException.class, () -> new ePrescripCode("123"));
    }

    // TESTS DigitalSignature
    @Test
    void testDigitalSignature_Valid() {
        byte[] data = {1, 2, 3, 4};
        DigitalSignature ds1 = new DigitalSignature(data);
        DigitalSignature ds2 = new DigitalSignature(new byte[]{1, 2, 3, 4});

        assertArrayEquals(data, ds1.getSignature());
        assertEquals(ds1, ds2);
        assertEquals(ds1.hashCode(), ds2.hashCode());
    }

    @Test
    void testDigitalSignature_Invalid() {
        assertThrows(IllegalArgumentException.class, () -> new DigitalSignature(null));
        assertThrows(IllegalArgumentException.class, () -> new DigitalSignature(new byte[]{}));
    }
}