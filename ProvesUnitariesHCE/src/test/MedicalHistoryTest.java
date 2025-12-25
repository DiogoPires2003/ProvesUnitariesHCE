package medicalconsultation;

import data.HealthCardID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicalHistoryTest {

    @Test
    void constructorCorrect() throws Exception {
        MedicalHistory mh =
                new MedicalHistory(new HealthCardID("1234567890123456"), 10);

        assertEquals(10, mh.getMemberShipNumb());
        assertEquals("", mh.getHistory());
    }

    @Test
    void constructorInvalidParameters() {
        assertThrows(IncorrectParametersException.class,
                () -> new MedicalHistory(null, 0));
    }

    @Test
    void addAnnotationCorrect() throws Exception {
        MedicalHistory mh =
                new MedicalHistory(new HealthCardID("1234567890123456"), 10);

        mh.addMedicalHistoryAnnotations("Patient stable");
        assertTrue(mh.getHistory().contains("Patient stable"));
    }

    @Test
    void changeDoctorCorrect() throws Exception {
        MedicalHistory mh =
                new MedicalHistory(new HealthCardID("1234567890123456"), 10);

        mh.setNewDoctor(20);
        assertEquals(20, mh.getMemberShipNumb());
    }
}
