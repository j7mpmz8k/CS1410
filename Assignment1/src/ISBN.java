import java.util.Scanner;
public class ISBN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN: ");
        int isbn9 = input.nextInt();

        // d = digit (ie. second digit)
        // n = remaining digits after d
        int d1 = isbn9 / 100_000_000;
        int n1 = isbn9 % 100_000_000;

        int d2 = n1 / 10_000_000;
        int n2 = n1 % 10_000_000;

        int d3 = n2 / 1_000_000;
        int n3 = n2 % 1_000_000;

        int d4 = n3 / 100_000;
        int n4 = n3 % 100_000;

        int d5 = n4 / 10_000;
        int n5 = n4 % 10_000;

        int d6 = n5 / 1_000;
        int n6 = n5 % 1_000;

        int d7 = n6 / 100;
        int n7 = n6 % 100;

        int d8 = n7 / 10;
        int d9 = n7 % 10;// n8 is the 9th digit

        System.out.print("The ISBN-10 number is: " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9);//still needs checksum as 10th digit

        //prints X if checksum is 10
        int checksum = (d1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;
        if  (checksum == 10) {
            System.out.println("X");
        }
        else {
            System.out.println(checksum);
        }
    }
}