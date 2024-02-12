package nclan.ac.ahart.cs.topic1;

/**
 * Code which demonstrates conversion from one number system to another.
 * Version 2 adds a pad left method for binary numbers.
 * Useful links
 *
 * @author ahart
 * @version 2
 * @see <a href="https://4sysops.com/archives/two-ways-to-integrate-github-with-azure-devops/"</a> for more info
 * @see <a href="https://www.azuredevopslabs.com/labs/azuredevops/github-integration/"</a> for more info
 */
public class NumberConvert {
    /**
     * Pad any binary string to this length, if nothing else supplied
     */
    protected static int DEFAULT_BIT_LENGTH = 8;

    /**
     * Program the conversion of decimal to binary using a similar algorithm as you would if you were
     * to do it using pen and paper.
     * Convert an integer to a binary number base. Only works with 8bit numbers.
     *
     * @param number number in decimal format
     * @return binary representation of number returned as a String
     */
    public static String DIYConvertDecimalToBinary(int number) {
        // array to store binary number
        int[] binaryNum = new int[8];

        // counter for binary array
        int i = 7;
        while (number > 0) {
            // storing remainder in binary array
            binaryNum[i] = number % 2;
            number = number / 2;
            i--;
        }

        StringBuilder sbOutput = new StringBuilder();
        for (int x : binaryNum) {
            sbOutput.append(x);
        }

        return sbOutput.toString();
    }


    /**
     * Convert an integer to a binary number base.
     *
     * @param number number in decimal format
     * @return binary representation of number returned as a String
     */
    public static String convertDecimalToBinary(int number) {
        //could have used
        //Integer.toBinaryString(number);
        return padLeftZeros(Integer.toString(number, 2));
    }


    /**
     * Convert an integer to a hexadecimal number base
     *
     * @param number number in decimal format
     * @return hexadecimal representation of number returned as a String
     */
    public static String convertDecimalToHex(int number) {
        //Could have used
        //Integer.toHexString(number);
        return Integer.toString(number, 16).toUpperCase();
    }

    /*
     * Convert a binary number to a decimal number base
     *
     * @param number number in binary format
     * @return decimal representation of the supplied binary number
     */

    /**
     * Convert a binary number represented by String to a decimal number base
     *
     * @param number number in binary format
     * @return decimal representation of the supplued binary number
     * @throws Exception Catches NumberFormatException and throws an Exception with a more user-friendly message.
     */
    public static int convertBinaryToDecimal(String number) throws Exception {
        try {
            return Integer.parseInt(number, 2);
        } catch (NumberFormatException nfe) {
            throw new Exception("Unable to parse supplied binary string to a decimal");
        }
    }

    /**
     * Convert a hexadecimal number to a decimal number base
     *
     * @param number number in hexadecimal format
     * @return decimal representation of the supplied binary number
     */
    public static int convertHexToDecimal(String number) {
        return Integer.parseInt(number, 16);
    }

    /**
     * Pad the binary string with 0's up to default bit length
     *
     * @param inputString binary representation
     * @return padded binary representation
     */
    public static String padLeftZeros(String inputString) {
        return padLeftZeros(inputString, DEFAULT_BIT_LENGTH);
    }

    /**
     * Pad the binary string with 0's up to default bit length
     *
     * @param inputString binary representation
     * @param length      pad string to this length
     * @return padded binary representation
     */
    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
