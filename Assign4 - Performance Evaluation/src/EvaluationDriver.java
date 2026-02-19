/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author James Dean Mathias
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_SIZE_START = 20_000;
    static final int ARRAY_SIZE_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {
        System.out.println("--- Linear Search Timing (unsorted) ---");
        demoLinearSearchUnsorted();
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        demoLinearSearchSorted();
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        demoBinarySearchSelectionSort();
        System.out.println("--- Binary Search Timing (Arrays.sort) ---");
        demoBinarySearchFastSort();
    }
    public static int[] generateNumbers(int howMany, int maxValue) {
        if (howMany >= 0) {//prevents attempt of "negative" array length which would normally cause `NegativeArraySizeException` error. Instead, Null will be returned.
            int[] randomArray = new int[howMany];//creates empty array with length equal to `howMany` parameter
            for (int i = 0; i < howMany; i++) {
                randomArray[i] = (int) (Math.random() * (maxValue + 1));//fills each index with random number of inclusive range: [0,maxValue]
            }
            return randomArray;
        } else {
            return null;
        }
    }
    public static boolean linearSearch(int[] data, int search) {
        //returns true if found else returns false
        for (int i : data) {
            if (i == search) {
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int[] data, int search) {
        //returns true if found else returns false
        int min = 0;
        int max = data.length - 1;
        int lookup;
        while (min <= max) {
            lookup = (max + min) / 2;
            if (data[lookup] == search) {
                return true;
            } else if (data[lookup] > search) {
                max = lookup - 1;
            } else {
                min = lookup + 1;
            }
        }
        return false;
    }
    public static void selectionSort(int[] data) {
        //sorts in place
        for (int start = 0; start < data.length - 1; start++) {
            int min = start;
            for (int scanned = start + 1; scanned < data.length; scanned++) {
                if (data[scanned] < data[min]) {
                    min = scanned;
                }
            }
            int temp = data[start];
            data[start] = data[min];
            data[min] = temp;
        }
    }
    public static void demoLinearSearchUnsorted() {
        //loops 5 times, each loop increasing searchable array size of: 20,000 -> 40,000 -> 60,000 -> 80,000 -> 100,000
        for (int arraySize = ARRAY_SIZE_START; arraySize <= MAX_ARRAY_SIZE; arraySize += ARRAY_SIZE_INCREMENT) {
            int foundCounter = 0;
            int[] arrayToSearch = generateNumbers(arraySize, MAX_VALUE);
            long startTime = System.currentTimeMillis();
            //linear searches each of the 5 unsorted arrays equal to NUMBER_SEARCHES
            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                int key = (int) (Math.random() * (MAX_VALUE + 1));//generates a single random number with inclusive range of [0, MAX_VALUE]
                if (linearSearch(arrayToSearch, key)) {
                    ++foundCounter;
                };
            }
            //prints time spent searching each of 5 arrays along with matches found and array size
            long timeSpent = System.currentTimeMillis() - startTime;
            System.out.printf("%-21s : %d\n", "Number of items", arraySize);
            System.out.printf("%-21s : %d\n", "Times value was found", foundCounter);
            System.out.printf("%-21s : %d ms\n", "Total search time", timeSpent);
            System.out.println();
        }
    }
    public static void demoLinearSearchSorted() {
        //loops 5 times, each loop increasing searchable array size of: 20,000 -> 40,000 -> 60,000 -> 80,000 -> 100,000
        for (int arraySize = ARRAY_SIZE_START; arraySize <= MAX_ARRAY_SIZE; arraySize += ARRAY_SIZE_INCREMENT) {
            int foundCounter = 0;
            int[] arrayToSearch = generateNumbers(arraySize, MAX_VALUE);
            long startTime = System.currentTimeMillis();

            selectionSort(arrayToSearch);
            //linear searches each of the 5 selection sorted arrays equal to NUMBER_SEARCHES
            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                int key = (int) (Math.random() * (MAX_VALUE + 1));//generates a single random number with inclusive range of [0, MAX_VALUE]
                if (linearSearch(arrayToSearch, key)) {
                    ++foundCounter;
                };
            }
            //prints time spent sorting/searching each of 5 arrays along with matches found and array size
            long timeSpent = System.currentTimeMillis() - startTime;
            System.out.printf("%-21s : %d\n", "Number of items", arraySize);
            System.out.printf("%-21s : %d\n", "Times value was found", foundCounter);
            System.out.printf("%-21s : %d ms\n", "Total search time", timeSpent);
            System.out.println();
        }
    }
    public static void demoBinarySearchSelectionSort() {
        //loops 5 times, each loop increasing searchable array size of: 20,000 -> 40,000 -> 60,000 -> 80,000 -> 100,000
        for (int arraySize = ARRAY_SIZE_START; arraySize <= MAX_ARRAY_SIZE; arraySize += ARRAY_SIZE_INCREMENT) {
            int foundCounter = 0;
            int[] arrayToSearch = generateNumbers(arraySize, MAX_VALUE);
            long startTime = System.currentTimeMillis();

            selectionSort(arrayToSearch);
            //binary searches each of the 5 selection sorted arrays equal to NUMBER_SEARCHES
            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                int key = (int) (Math.random() * (MAX_VALUE + 1));//generates a single random number with inclusive range of [0, MAX_VALUE]
                if (binarySearch(arrayToSearch, key)) {
                    ++foundCounter;
                };
            }
            //prints time spent sorting/searching each of 5 arrays along with matches found and array size
            long timeSpent = System.currentTimeMillis() - startTime;
            System.out.printf("%-21s : %d\n", "Number of items", arraySize);
            System.out.printf("%-21s : %d\n", "Times value was found", foundCounter);
            System.out.printf("%-21s : %d ms\n", "Total search time", timeSpent);
            System.out.println();
        }
    }
    public static void demoBinarySearchFastSort() {
        //loops 5 times, each loop increasing searchable array size of: 20,000 -> 40,000 -> 60,000 -> 80,000 -> 100,000
        for (int arraySize = ARRAY_SIZE_START; arraySize <= MAX_ARRAY_SIZE; arraySize += ARRAY_SIZE_INCREMENT) {
            int foundCounter = 0;
            int[] arrayToSearch = generateNumbers(arraySize, MAX_VALUE);
            long startTime = System.currentTimeMillis();

            java.util.Arrays.sort(arrayToSearch);
            //binary searches each of the 5 quick sorted arrays equal to NUMBER_SEARCHES
            for (int i = 0; i < NUMBER_SEARCHES; i++) {
                int key = (int) (Math.random() * (MAX_VALUE + 1));//generates a single random number with inclusive range of [0, MAX_VALUE]
                if (binarySearch(arrayToSearch, key)) {
                    ++foundCounter;
                };
            }
            //prints time spent sorting/searching each of 5 arrays along with matches found and array size
            long timeSpent = System.currentTimeMillis() - startTime;
            System.out.printf("%-21s : %d\n", "Number of items", arraySize);
            System.out.printf("%-21s : %d\n", "Times value was found", foundCounter);
            System.out.printf("%-21s : %d ms\n", "Total search time", timeSpent);
            System.out.println();
        }
    }
}
