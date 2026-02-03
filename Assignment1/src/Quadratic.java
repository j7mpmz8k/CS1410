import java.util.Scanner;
public class Quadratic {
    public static void main(String[] args) {

        //getting user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double discriminant = b * b - (4 * a * c);

        if (discriminant > 0) {
            double r1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double r2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("There are two roots for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);
        }
        else if (discriminant == 0) {
            double r1 = -b / (2 * a);//omitted discriminant since adding or subtracting zero gives the same result
            System.out.println("There is one root for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);
        }
        else if (discriminant < 0) {
            //can't take the square root of a negative
            System.out.println("There are no roots for the quadratic equation with these coefficients.");
        }
    }
}