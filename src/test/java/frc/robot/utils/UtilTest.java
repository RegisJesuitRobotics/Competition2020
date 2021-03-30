package frc.robot.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilTest {
    @Test
    public void testSimplifyAngle() {
        assertEquals(0, Util.simplifyAngle(0.0), 0);
        assertEquals(0, Util.simplifyAngle(360), 0);
        assertEquals(0, Util.simplifyAngle(720), 0);
        assertEquals(90, Util.simplifyAngle(90), 0);
        assertEquals(90, Util.simplifyAngle(450), 0);
        assertEquals(270, Util.simplifyAngle(-90), 0);
        assertEquals(270, Util.simplifyAngle(-450), 0);
        assertEquals(0.5, Util.simplifyAngle(0.5), 0);
        assertEquals(0.5, Util.simplifyAngle(360.5), 0);

    }

    @Test
    public void testFastestDirection() {
        assertEquals(1, Util.getFastestDirection(0, 90));
        assertEquals(1, Util.getFastestDirection(359, 60));
        assertEquals(1, Util.getFastestDirection(0, 179));
        assertEquals(-1, Util.getFastestDirection(90, 0));
        assertEquals(-1, Util.getFastestDirection(179, 0));
        assertEquals(1, Util.getFastestDirection(0.2, 1));
        assertEquals(-1, Util.getFastestDirection(1.2, 1));
        assertEquals(-1, Util.getFastestDirection(181, 180));
        assertEquals(1, Util.getFastestDirection(179.9, 180));
        assertEquals(-1, Util.getFastestDirection(183, 180));
        
        assertEquals(1, Util.getFastestDirection(359, 1));
        assertEquals(-1, Util.getFastestDirection(1, 359));
        assertEquals(-1, Util.getFastestDirection(179, 359));
        assertEquals(1, Util.getFastestDirection(180, 359));

        assertEquals(1, Util.getFastestDirection(359.999, 60));
    }

    @Test
    public void testInRange() {
        assertTrue(Util.isInAngleRange(0, 180, 90));
        assertTrue(Util.isInAngleRange(340, 90, 4));
        assertTrue(Util.isInAngleRange(359, 60, 50));
        assertTrue(Util.isInAngleRange(359, 60, 359));
        assertTrue(Util.isInAngleRange(350, 60, -0));
        assertTrue(Util.isInAngleRange(60, 180, 180));

        assertTrue(Util.isInAngleRange(60, 90, 90));
        assertTrue(Util.isInAngleRange(359, 60, 60));
        assertTrue(Util.isInAngleRange(330, 0, 330));
        assertTrue(Util.isInAngleRange(350, 40, 353));

        assertTrue(Util.isInAngleRange(349, 40.399, 40.399));
    }
}
