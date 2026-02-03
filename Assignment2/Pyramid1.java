import java.util.Scanner;

public class Pyramid1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int totalLines = input.nextInt();

        // finds length of largest number
        String maxNumString = "" + totalLines;
        int width = maxNumString.length() + 1;

        // sets up string format
        String format = "%" + width + "d";
        String emptyFormat = "%" + width + "s";

        // loop for each row
        for (int row = 1; row <= totalLines; row++) {

            // Prints left hand empty spaces
            // empty spaces is totalLines - row
            for (int spaces = 0; spaces < totalLines - row; spaces++) {
                System.out.printf(emptyFormat, "");
            }

            // Prints the decreasing numbers from the center of each row
            for (int number = row; number >= 1; number--) {
                System.out.printf(format, number);
            }

            // Prints the increasing numbers from the left
            for (int number = 2; number <= row; number++) {
                System.out.printf(format, number);
            }

            System.out.println();
        }
    }
}
