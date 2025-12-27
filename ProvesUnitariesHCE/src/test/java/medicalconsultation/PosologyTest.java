package test.java.medicalconsultation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PosologyTest {

    @Test
    void constructorCorrect() {
        Posology p = new Posology(1, 1, FqUnit.DAY);
        assertEquals(1, p.getDose());
        assertEquals(1, p.getFreq());
        assertEquals(FqUnit.DAY, p.getFreqUnit());
    }

    @Test
    void constructorInvalidDose() {
        assertThrows(IllegalArgumentException.class,
                () -> new Posology(0, 1, FqUnit.DAY));
    }

    @Test
    void constructorInvalidFrequency() {
        assertThrows(IllegalArgumentException.class,
                () -> new Posology(1, 0, FqUnit.DAY));
    }

    @Test
    void setDoseInvalid() {
        Posology p = new Posology(1, 1, FqUnit.DAY);
        assertThrows(IllegalArgumentException.class,
                () -> p.setDose(-2));
    }

    @Test
    void setFrequencyInvalid() {
        Posology p = new Posology(1, 1, FqUnit.DAY);
        assertThrows(IllegalArgumentException.class,
                () -> p.setFreq(0));
    }
}
