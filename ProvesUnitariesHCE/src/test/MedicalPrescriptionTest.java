package medicalconsultation;

import data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MedicalPrescriptionTest {

    private MedicalPrescription mp;
    private ProductID prodID;
    private String[] instruc;

    @BeforeEach
    void setup() {
        mp = new MedicalPrescription(
                new HealthCardID("1234567890123456"),
                1,
                "flu"
        );

        prodID = new ProductID("123456789012");

        instruc = new String[]{
                "BEFORELUNCH",
                "10",
                "1",
                "1",
                "DAY",
                "Take with water"
        };
    }

    @Test
    void addLineCorrect() throws Exception {
        mp.addLine(prodID, instruc);
        assertEquals(1, mp.getLines().size());
    }

    @Test
    void addLineRepeatedProduct() throws Exception {
        mp.addLine(prodID, instruc);
        assertThrows(ProductAlreadyInPrescriptionException.class,
                () -> mp.addLine(prodID, instruc));
    }

    @Test
    void modifyDoseCorrect() throws Exception {
        mp.addLine(prodID, instruc);
        mp.modifyDoseInLine(prodID, 3);

        assertEquals(3,
                mp.getLines().get(prodID).getPosology().getDose());
    }

    @Test
    void modifyDoseProductNotInPrescription() {
        assertThrows(ProductNotInPrescriptionException.class,
                () -> mp.modifyDoseInLine(prodID, 2));
    }

    @Test
    void removeLineCorrect() throws Exception {
        mp.addLine(prodID, instruc);
        mp.removeLine(prodID);
        assertTrue(mp.getLines().isEmpty());
    }

    @Test
    void removeLineProductNotInPrescription() {
        assertThrows(ProductNotInPrescriptionException.class,
                () -> mp.removeLine(prodID));
    }
}
