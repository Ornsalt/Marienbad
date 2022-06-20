// It's declaring the package that the class is in.
package terminal;

// It's importing the Scanner class from the java.util package.
import java.util.Scanner;

/**
 * It's a class that contains static methods that prompt the user for input, and
 * returns the input.
 */
public final class Input {
    /**
     * It's creating a new Scanner object, and assigning it to the SCANNER variable.
     */
    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * It takes a string as an argument, and returns a string.
     * 
     * @param prompt The prompt to display to the user.
     * @return The string that was entered by the user.
     */
    final static public String getStr(String prompt) {
        System.out.printf("%s", prompt);
        return (SCANNER.next());
    }

    /**
     * It prompts the user for a single character, and returns that character.
     * 
     * @param prompt The prompt to display to the user.
     * @return A single character.
     */
    final static public char getChar(String prompt) {
        String buffer = null;

        do {
            System.out.printf("%s", prompt);
        } while ((buffer = SCANNER.next()).length() != 1);
        return (buffer.charAt(0));
    }

    /**
     * It takes a string as an argument, and returns a string.
     * 
     * @param prompt The prompt to display to the user.
     * @return The string that was entered by the user.
     */
    final static public boolean getBool(String prompt) {
        boolean find = false;
        boolean bool = false;

        do {
            try {
                System.out.printf("%s", prompt);
                bool = SCANNER.nextBoolean();
                find = true;
            } catch (java.util.InputMismatchException e) {
                SCANNER.nextLine();
            }
        } while (!find);
        return (bool);
    }

    /**
     * It reads a long from the console, and if the user enters a non-long, it will
     * keep asking until the user enters a long.
     * 
     * @param prompt The prompt to display to the user.
     * @return The number that the user inputs.
     */
    final static public long getNbr(String prompt) {
        boolean find = false;
        long nbr = 0;

        do {
            try {
                System.out.printf("%s", prompt);
                nbr = SCANNER.nextLong();
                find = true;
            } catch (java.util.InputMismatchException e) {
                SCANNER.nextLine();
            }
        } while (!find);
        return (nbr);
    }

    /**
     * It takes a string prompt as an argument and returns a double value.
     * 
     * @param prompt The prompt to display to the user.
     * @return A double value.
     */
    final static public double getDeci(String prompt) {
        boolean find = false;
        double deci = 0;

        do {
            try {
                System.out.printf("%s", prompt);
                deci = SCANNER.nextDouble();
                find = true;
            } catch (java.util.InputMismatchException e) {
                SCANNER.nextLine();
            }
        } while (!find);
        return (deci);
    }
}