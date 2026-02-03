import java.util.Scanner;

public class Pyramid1Manual {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int totalLines = input.nextInt();

        // Find width of the largest number
        String maxString = "" + totalLines;
        int width = maxString.length() + 1; // +1 for the space between numbers

        for (int row = 1; row <= totalLines; row++) {

            // Print leading empty columns
            // We need to print 'width' spaces for every empty column
            for (int spaces = 0; spaces < totalLines - row; spaces++) {
                for (int w = 0; w < width; w++) {
                    System.out.print(" ");
                }
            }

            // Print decreasing numbers
            for (int number = row; number >= 1; number--) {
                // Calculate padding needed for this specific number
                String numStr = "" + number;
                int padding = width - numStr.length();
                
                // Print padding spaces
                for (int p = 0; p < padding; p++) {
                    System.out.print(" ");
                }
                // Print the number
                System.out.print(number);
            }

            // Print increasing numbers
            for (int number = 2; number <= row; number++) {
                // Calculate padding needed
                String numStr = "" + number;
                int padding = width - numStr.length();
                
                // Print padding spaces
                for (int p = 0; p < padding; p++) {
                    System.out.print(" ");
                }
                // Print the number
                System.out.print(number);
            }

            System.out.println();
        }
    }
}
