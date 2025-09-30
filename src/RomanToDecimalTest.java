import static org.junit.Assert.*;

/**
 * JUnit4 test class for RomanToDecimal
 * @author Kayla Cao
 * @version 09.30.2025
 */
public class RomanToDecimalTest {
    /**
     * JUnit test method for romanToDecimal method
     */
    @org.junit.Test
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("ii"), 2);
        assertEquals(RomanToDecimal.romanToDecimal("iv"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("xc"), 90);
        assertEquals(RomanToDecimal.romanToDecimal("CD"), 400);
        assertEquals(RomanToDecimal.romanToDecimal("CM"), 900);
        assertEquals(RomanToDecimal.romanToDecimal("VII"), 7);
        assertEquals(RomanToDecimal.romanToDecimal("XXVI"), 26);
        assertEquals(RomanToDecimal.romanToDecimal("XIV"), 14);
        assertEquals(RomanToDecimal.romanToDecimal("XCIV"), 94);

        assertEquals(RomanToDecimal.romanToDecimal("IIVI"), 6);
        assertEquals(RomanToDecimal.romanToDecimal("IIIVII"), 8);
        assertEquals(RomanToDecimal.romanToDecimal("IIIXVIII"), 19);
        assertEquals(RomanToDecimal.romanToDecimal("IXIXIX"), 31);

        assertEquals(RomanToDecimal.romanToDecimal("HELLO"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("what's up"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("lalalallalalala"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("mmmm_yum_yum"), -1);

        assertNotEquals(RomanToDecimal.romanToDecimal("IV"), 6);
        assertNotEquals(RomanToDecimal.romanToDecimal("IXIXIX"), 27);
    }
}