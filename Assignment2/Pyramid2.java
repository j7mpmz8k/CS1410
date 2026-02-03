import java.util.Scanner;

public class Pyramid2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int totalLines = input.nextInt();

        final int BASE = 2;

        // Finds length of largest number
        long maxValue = (long) Math.pow(BASE, totalLines - 1);
        String maxString = "" + maxValue;
        int width = maxString.length() + 1;

        // sets up string format
        String format = "%" + width + "d";
        String emptyFormat = "%" + width + "s";

        for (int row = 1; row <= totalLines; row++) {

            // left hand empty spaces
            for (int spaces = 0; spaces < totalLines - row; spaces++) {
                System.out.printf(emptyFormat, "");
            }

            // increasing powers of 2
            for (int power = 0; power < row; power++) {
                long value = (long) Math.pow(BASE, power);
                System.out.printf(format, value);
            }

            // Descending powers of 2
            for (int power = row - 2; power >= 0; power--) {
                long value = (long) Math.pow(BASE, power);
                System.out.printf(format, value);
            }

            System.out.println();
        }
    }
}
