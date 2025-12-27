package test.java.medicalconsultation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TakingGuidelineTest {

    @Test
    void constructorCorrect() {
        TakingGuideline tg = new TakingGuideline(
                dayMoment.BEFORELUNCH,
                7,
                1,
                1,
                FqUnit.DAY,
                "Take with water"
        );

        assertEquals(dayMoment.BEFORELUNCH, tg.getDayMoment());
        assertEquals(7, tg.getDuration());
        assertEquals(1, tg.getPosology().getDose());
        assertEquals("Take with water", tg.getInstructions());
    }

    @Test
    void constructorInvalidDuration() {
        assertThrows(IllegalArgumentException.class,
                () -> new TakingGuideline(
                        dayMoment.BEFORELUNCH,
                        0,
                        1,
                        1,
                        FqUnit.DAY,
                        null
                ));
    }

    @Test
    void constructorNullDayMoment() {
        assertThrows(IllegalArgumentException.class,
                () -> new TakingGuideline(
                        null,
                        5,
                        1,
                        1,
                        FqUnit.DAY,
                        null
                ));
    }
}
