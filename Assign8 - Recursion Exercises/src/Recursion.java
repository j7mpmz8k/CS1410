public class Recursion {
    public static void main(String[] args) {

        int[] sumMe = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        System.out.printf("Array Sum: %d\n", arraySum(sumMe, 0));

        int[] minMe = { 0, 1, 1, 2, 3, 5, 8, -42, 13, 21, 34, 55, 89 };
        System.out.printf("Array Min: %d\n", arrayMin(minMe, 0));

        String[] amISymmetric =  {
                "You can cage a swallow can't you but you can't swallow a cage can you",
                "I still say cS 1410 is my favorite class"
        };
        for (String test : amISymmetric) {
            String[] words = test.toLowerCase().split(" ");
            System.out.println();
            System.out.println(test);
            System.out.printf("Is word symmetric: %b\n", isWordSymmetric(words, 0, words.length - 1));
        }

        double[][] masses = {
                { 51.18 },
                { 55.90, 131.25 },
                { 69.05, 133.66, 132.82 },
                { 53.43, 139.61, 134.06, 121.63 }
        };
        System.out.println();
        System.out.println("--- Weight Pyramid ---");
        for (int row = 0; row < masses.length; row++) {
            for (int column = 0; column < masses[row].length; column++) {
                double weight = computePyramidWeights(masses, row, column);
                System.out.printf("%.2f ", weight);
            }
            System.out.println();
        }

        char[][] image = {
                {'*','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ','*','*',' ',' '},
                {' ','*',' ',' ','*','*','*',' ',' ',' '},
                {' ','*','*',' ','*',' ','*',' ','*',' '},
                {' ','*','*',' ','*','*','*','*','*','*'},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ','*','*','*',' ',' ','*',' '},
                {' ',' ',' ',' ',' ','*',' ',' ','*',' '}
        };
        int howMany = howManyOrganisms(image);
        System.out.println();
        System.out.println("--- Labeled Organism Image ---");
        for (char[] line : image) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.printf("There are %d organisms in the image.\n", howMany);

    }
    public static boolean isWordSymmetric(String[] words, int start, int end) {
        if (start >= end) {//start and end move closer to center each step
            return true;
        } 
        return words[start].equalsIgnoreCase(words[end]) && isWordSymmetric(words, start + 1, end - 1);
    }

    public static long arraySum(int[] data, int position) {
        if (position == data.length || data.length == 0) {//true if either reached the end of array OR array is empty
            return 0;
        }
        return data[position] + arraySum(data, position + 1);
    }

    public static int arrayMin(int[] data, int position) {
        if (position == data.length - 1) {//true if idx is last position
            return data[position];
        } else if (data.length == 0) {//checks if empty array
            return 0;
        }
        return Math.min(data[position], arrayMin(data, position + 1));
    }

    public static double computePyramidWeights(double[][] masses, int row, int column) {
        if (row < 0 || column < 0 || row >= masses.length || column >= masses[row].length) {//true if out of bounds
            return 0;
        }
        return masses[row][column] 
            + computePyramidWeights(masses, row - 1, column - 1) / 2//top left
            + computePyramidWeights(masses, row - 1, column) / 2;//top right
    }

    public static int howManyOrganisms(char[][] image) {
        int organismCounter  = 0;
        char organismID = 96;//char before 'a' since oragnismID is incremented right before assignment to organism
        //search each cell for new organism
        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[row].length; col++) {
                if (image[row][col] == '*') {// '*' always same organism, recursive step stops after a gap is found
                    organismCounter++;
                    organismID++;
                    scanOrganism(image, row, col, organismID);
                }
            }
        }
        return organismCounter;
    }
    public static void scanOrganism(char[][] image, int row, int col, char organismID) {
        boolean inBounds = row >= 0 && col >= 0 && row < image.length && col < image[row].length;
        if (inBounds && image[row][col] == '*') {
            image[row][col] = organismID;
            //crawlers to uniquely label each cell of new organism
            scanOrganism(image, row, col + 1, organismID);//seek right
            scanOrganism(image, row + 1, col, organismID);//seek down
            scanOrganism(image, row, col - 1, organismID);//seek left
            scanOrganism(image, row - 1, col, organismID);//seek up
        }
    }
}
