import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Roman numeral to decimal converter
 * @author Kayla Cao
 * @version 09.30.2025
 * used Flint for help: https://app.flintk12.com/chats/67927f66-f8c7-4038-94af-4cf7b759d935
 */
public class RomanToDecimal {
    /**
     * Converts a Roman numeral string to its decimal equivalent and subtracts invariants by calling invariantsDifference
     * @param roman the Roman numeral string to convert
     * @return the decimal value of the Roman numeral, or -1 if invalid characters found
     */
    public static int romanToDecimal(String roman) {
        roman = roman.toUpperCase();
        ArrayList<Character> romanChars = new ArrayList<>();
        romanChars.add('I');
        romanChars.add('V');
        romanChars.add('X');
        romanChars.add('L');
        romanChars.add('C');
        romanChars.add('D');
        romanChars.add('M');
        int[] values = {1, 5, 10, 50, 100, 500, 1000};
        int sum = 0;
        for (int i = 0; i < roman.length(); i++) {
            int index = romanChars.indexOf(roman.charAt(i));
            if (index == -1) {
                return -1;
            }
            sum += values[index];
        }
        return sum - invariantDifference(roman);
    }

    /**
     * Calculates the total subtraction needed to correct for invariants, called in romanToDecimal
     * @param roman the Roman numeral string to analyze
     * @return the total amount to subtract from the decimal calculation
     */
    public static int invariantDifference(String roman) {
        roman = roman.toUpperCase();
        String[] invariants = {"IV", "IX", "XL", "XC", "CD", "CM"};
        int[] differences = {2, 2, 20, 20, 200, 200};
        int differenceSum = 0;
        for (String invariant : invariants) {
            if (roman.contains(invariant)) {
                differenceSum += differences[Arrays.asList(invariants).indexOf(invariant)];
            }
        }
        return differenceSum;
    }

    /**
     * Takes user input and converts it to decimal form
     */
    public static void userInputToDecimal() {
        Scanner in = new Scanner(System.in);
        int decimal;
        String romanInput = "";
        while (true) {
            System.out.print("Enter a roman numeral to convert to decimal: ");
            romanInput = in.nextLine().trim();
            if (romanInput.isEmpty()) {
                System.out.println("Invalid input");
                continue;
            }
            decimal = romanToDecimal(romanInput);
            if (decimal == -1) {
                System.out.println("Invalid input");
                continue;
            }
            break;
        }
        System.out.println("Input: " + romanInput + " => output: " + decimal);
    }

    /**
     * Main method for class RomanToDecimal
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int decimal;
        for (String s : args) {
            decimal = romanToDecimal(s);
            System.out.println("Input: " + s + " => output: " + (decimal != -1 ? decimal : "invalid"));
        }
        userInputToDecimal();
    }
}