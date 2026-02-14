import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        System.out.print("Enter 10 numbers: ");
        Scanner inputNumbers = new Scanner(System.in);
        int[] numbersTen = new int[10];
        for (int i = 0; i < 10; i++) {
            numbersTen[i] = inputNumbers.nextInt();
        }
        int[] reversedTenNumbers = new int[10];
        for (int i = 0, j = numbersTen.length - 1; i < numbersTen.length; i++, j--) {
            reversedTenNumbers[i] = numbersTen[j];
        }
        arrayReport(numbersTen);
        arrayReport(reversedTenNumbers);
    }
    public static void arrayReport(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
