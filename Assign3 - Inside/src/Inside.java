/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        System.out.println("--- Report of Points and Circles ---");
        System.out.println();
        for (int circle = 0; circle < circleX.length; circle++) {
            for  (int point = 0; point < ptX.length; point++) {
                reportPoint(ptX[point], ptY[point]);
                if (isPointInsideCircle(ptX[point], ptY[point], circleX[circle], circleY[circle], circleRadius[circle])) {
                    System.out.print(" is inside ");
                } else {
                    System.out.print(" is outside ");
                }
                reportCircle(circleX[circle], circleY[circle], circleRadius[circle]);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("--- Report of Points and Rectangles ---");
        System.out.println();
        for (int rect = 0; rect < rectLeft.length; rect++) {
            for  (int point = 0; point < ptX.length; point++) {
                reportPoint(ptX[point], ptY[point]);
                if (isPointInsideRectangle(ptX[point], ptY[point], rectLeft[rect], rectTop[rect], rectWidth[rect], rectHeight[rect])) {
                    System.out.print(" is inside ");
                } else {
                    System.out.print(" is outside ");
                }
                reportRectangle(rectLeft[rect], rectTop[rect], rectWidth[rect], rectHeight[rect]);
                System.out.println();
            }
        }

    }

    public static void reportPoint(double x, double y) {
        //prints the details for a single point.  For example it would print, without a newline: Point(1.0, 1.0)
        System.out.print("Point(" + x + ", " + y + ")");
    }
    public static void reportCircle(double x, double y, double r) {
        //prints the details for a single circle.  For example it would print, without a newline: Circle(0.0, 0.0) Radius: 3.0
        System.out.print("Circle(" + x + ", " + y + ") Radius: " + r);
    }
    public static void reportRectangle(double left, double top, double width, double height) {
        //prints the details for a single rectangle.
        //The report of the rectangle should show the left, top, right, and bottom values, rather than the left, top, width, and height.
        double right = left + width;
        double bottom = top - height;
        System.out.print("Rectangle(" + left + ", " + top + ", " + right + ", " + bottom + ") ");
    }
    public static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        //tests if a point is inside a circle.
        //A point on the edge of a circle is considered inside the circle.
        //This method should not print anything to the console.
        double dX =  circleX - ptX;
        double dY =  circleY - ptY;
        double distance = Math.sqrt(dX * dX + dY * dY);
        return circleRadius >= distance;
    }
    public static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        //tests if a point is inside a rectangle.
        //A point on the edge of a rectangle is considered inside the rectangle.
        //This method should not print anything to the console.
        double rRight =  rLeft + rWidth;
        double rBottom =  rTop - rHeight;
        boolean insideX = ptX >= rLeft && ptX <= rRight;
        boolean insideY = ptY >= rBottom && ptY <= rTop;
        return insideX && insideY;
    }
}
