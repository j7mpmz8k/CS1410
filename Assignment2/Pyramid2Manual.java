import java.util.Scanner;

public class Pyramid2Manual {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int totalLines = input.nextInt();
        final int BASE = 2;

        // Find width of the largest number
        long maxValue = (long) Math.pow(BASE, totalLines - 1);
        String maxString = "" + maxValue;
        int width = maxString.length() + 1; // +1 for spacing

        for (int row = 1; row <= totalLines; row++) {

            // Print leading empty columns
            for (int spaces = 0; spaces < totalLines - row; spaces++) {
                for (int w = 0; w < width; w++) {
                    System.out.print(" ");
                }
            }

            // Print increasing powers of 2
            for (int power = 0; power < row; power++) {
                long value = (long) Math.pow(BASE, power);
                
                // Manual padding logic
                String valStr = "" + value;
                int padding = width - valStr.length();
                for (int p = 0; p < padding; p++) {
                    System.out.print(" ");
                }
                System.out.print(value);
            }

            // Print descending powers of 2
            for (int power = row - 2; power >= 0; power--) {
                long value = (long) Math.pow(BASE, power);
                
                // Manual padding logic
                String valStr = "" + value;
                int padding = width - valStr.length();
                for (int p = 0; p < padding; p++) {
                    System.out.print(" ");
                }
                System.out.print(value);
            }

            System.out.println();
        }
    }
}
