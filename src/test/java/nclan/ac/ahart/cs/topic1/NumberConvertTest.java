package nclan.ac.ahart.cs.topic1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the NumberConvert class.
 *
 * @author ahart
 */
class NumberConvertTest {

    @Test
    void convertDecimalToBinary() {
        // Requires the padLeftZeros to be present to pad the output to 8 total digits.
        assertEquals("00001000", NumberConvert.convertDecimalToBinary(8));
        assertEquals("00001100", NumberConvert.convertDecimalToBinary(12));
        assertEquals("00010100", NumberConvert.convertDecimalToBinary(20));
    }

    @Test
    void convertDecimalToHex() {
        assertEquals("8", NumberConvert.convertDecimalToHex(8));
        assertEquals("C", NumberConvert.convertDecimalToHex(12));
        assertEquals("14", NumberConvert.convertDecimalToHex(20));
    }

    @Test
    void convertBinaryToDecimal() throws Exception {
        assertEquals(8, NumberConvert.convertBinaryToDecimal("1000"));
        assertEquals(85, NumberConvert.convertBinaryToDecimal("1010101"));
        assertEquals(45, NumberConvert.convertBinaryToDecimal("101101"));
    }

    @Test
    void convertBinaryToDecimalExceptions() {
        Exception thrown = assertThrows(Exception.class, () -> NumberConvert.convertBinaryToDecimal("100r0"));
        assertTrue(thrown.getMessage().contains("Unable to parse supplied binary string to a decimal"));
    }

    @Test
    void convertHexToDecimal() {
        assertEquals(45, NumberConvert.convertHexToDecimal("2D"));
        assertEquals(212, NumberConvert.convertHexToDecimal("D4"));
        assertEquals(171, NumberConvert.convertHexToDecimal("AB"));
    }

    @Test
    void DIYConvertDecimalToBinary() {
        // Requires the padLeftZeros to be present to pad the output to 8 total digits.
        assertEquals("00001000", NumberConvert.DIYConvertDecimalToBinary(8));
        assertEquals("00001100", NumberConvert.DIYConvertDecimalToBinary(12));
        assertEquals("00010100", NumberConvert.DIYConvertDecimalToBinary(20));

    }
}