package medicalconsultation;

import data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultationTerminalTest {

    private ConsultationTerminal ct;
    private ProductID prodID;
    private String[] instruc;

    @BeforeEach
    void setup() {
        ct = new ConsultationTerminal();
        ct.setHealthNationalService(new HealthNationalServiceStub());

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
    void fullUseCaseHappyPath() throws Exception {
        ct.initRevision(
                new HealthCardID("1234567890123456"),
                "flu");

        ct.enterMedicalAssessmentInHistory("All good");
        ct.initMedicalPrescriptionEdition();
        ct.enterMedicineWithGuidelines(prodID, instruc);
        ct.modifyDoseInLine(prodID, 2);
        ct.removeLine(prodID);

        assertTrue(ct.isRevisionStarted());
    }

    @Test
    void enterAssessmentWithoutInitRevision() {
        assertThrows(ProceduralException.class,
                () -> ct.enterMedicalAssessmentInHistory("Fail"));
    }
}
