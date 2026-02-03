## Java 25:
```java
void main() {
    System.out.println("Hello, World!");
}
```
where the old method would require setting up a class and declaring both the class and the method as public. If public is not declared it is private however Java25 ad an exception allowing the JVM to run the main method
## Java 21:
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

```
</details>

***
### signature
<details><summary></summary>

* `static` means the method it tied directly to the class without an instance/object
* `String[] args` is for entering arguments when running the program even if no arguments are used.
* `void` means nothing is returned, else the type of the return value must instead be declared ie. `int`, `boolean`, ect.
</details>

***
### printing to console
<details><summary></summary>

* evaluated left to right, `+` initially means addition, but when adding to a string, `3` is converted to `"3"` to concat to `"abc"` to create `"3abc"`
    * `System.out.print(System.out.println(1 + 2 + "abc" + 1 + 2););` -> output: "3abc12"
    * if intending to concat `1` & `2` instead of adding, use `"" + 1 + 2` instead 
</details>

***
### format fields
<details><summary></summary>

* builds template instead of concatenation
* use `String.format()` for formatting a variable into a `String`
* use `printf()` for formatting a string to output to terminal
* ie. `%6.2f`
  * ***trigger*** -> `%` indicates special command proceeds
  * ***width*** -> `6` indicates 6 total characters in template, will right align with spaces on the left if needed. default=unlimited (will not truncate)
  * ***separator*** special modifier (may also be combined)
    * dot `.` indicates a decimal number followed by precision
      * can also be used with `String`, the precision number would then truncate the string(can't truncate non-floating point numbers like `int` using this method)
    * comma `,` automatically adds commas ie. "1,000,000"
    * minus sign `-` left aligns everything instead of right
    * plus sign `+` forces a "+" before each number even for negatives
    * left parentheses `(` forces a "-" before each number even for positive numbers
    * zero (`0`) converts padding of zeros to spaces
  * ***precision*** -> `2` forces length of 2 characters after decimal, will round if needed or add zeros. default=0 (needs the dot separator)
  * ***conversion type*** -> `f` stands for 'floating point' which is used for `double` or `float` types
    * `d` for `int`/`long`/`short`
    * `s` for `String`
  * ```java
    //ie. %.6s and %6.2f
    void main() {
        String var1 = "Number PI is:";
        double num1 = 3.14159;
        System.out.println("Number PI is:" + num1);//output: "Number PI is:3.14159"
        System.out.printf("%.6s %6.2f", var1, num1);//output: "PI is:   3.14"   
    }
    ```
</details>

***
### data types
<details><summary></summary>

| Type       | Bit Size | Signed? | Range                       | Notes                                         |
|------------|----------|---------|-----------------------------|-----------------------------------------------|
| **byte**   | 8-bit    | **Yes** | -128 to 127                 | ie. `byte va1 = 127`                          |
| **short**  | 16-bit   | **Yes** | -32,768 to 32,767           | no suffix                                     |
| **char**   | 16-bit   | **No**  | 0 to 65,535                 | unicode enclosed in single quotes (`'A'`)     |
| **int**    | 32-bit   | **Yes** | -2.1 billion to 2.1 billion | default for whole numbers                     |
| **float**  | 32-bit   | **Yes** | ±1.4e-45 to ±3.4e+38        | needs `F` suffix durring assignment           |
| **long**   | 64-bit   | **Yes** | -9.22e+18 to 9.22e+18       | needs `L` suffix durring assignment           | 
| **double** | 64-bit   | **Yes** | ±4.9e-324 to ±1.8e+308      | default for decimals                          |

* unicode ascii characters
| Decimal | Char  | Decimal | Char | Decimal | Char | Decimal | Char |
|---------|-------|---------|------|---------|------|---------|------|
|  32     | space |  56     | 8    | 80      | P    | 104     | h    |
|  33     |   !   |  57     | 9    | 81      | Q    | 105     | i    |
|  34     |   "   |  58     | :    | 82      | R    | 106     | j    |
|  35     |   #   |  59     | ;    | 83      | S    | 107     | k    |
|  36     |   $   |  60     | <    | 84      | T    | 108     | l    |
|  37     |   %   |  61     | =    | 85      | U    | 109     | m    |
|  38     |   &   |  62     | >    | 86      | V    | 110     | n    |
|  39     |   '   |  63     | ?    | 87      | W    | 111     | o    |
|  40     |   (   |  64     | @    | 88      | X    | 112     | p    |
|  41     |   )   |  65     | A    | 89      | Y    | 113     | q    |
|  42     |   *   |  66     | B    | 90      | Z    | 114     | r    |
|  43     |   +   |  67     | C    | 91      | [    | 115     | s    |
|  44     |   ,   |  68     | D    | 92      | \    | 116     | t    |
|  45     |   -   |  69     | E    | 93      | ]    | 117     | u    |
|  46     |   .   |  70     | F    | 94      | ^    | 118     | v    |
|  47     |   /   |  71     | G    | 95      | _    | 119     | w    |
|  48     |   0   |  72     | H    | 96      | `    | 120     | x    |
|  49     |   1   |  73     | I    | 97      | a    | 121     | y    |
|  50     |   2   |  74     | J    | 98      | b    | 122     | z    |
|  51     |   3   |  75     | K    | 99      | c    | 123     | {    |
|  52     |   4   |  76     | L    | 100     | d    | 124     | |    |
|  53     |   5   |  77     | M    | 101     | e    | 125     | }    |
|  54     |   6   |  78     | N    | 102     | f    | 126     | ~    |
|  55     |   7   |  79     | O    | 103     | g    |         |      |

</details>

***
### type casting
<details><summary></summary>

* **automatic** when widening from smaller type to larger 
  * integer path(signed number, ie. positive or negative)
    * `byte` -> `short` -> `int` -> `long` -> `float` -> `double`
  * character path(unsigned number, ie. zero or positive)
   * `char` -> `int` -> `long` -> `float` -> `double`
  * note compound operators like `+=` include auto type casting
    ```java
    int x = 5;
    x += 4.5;//output: 9 since `4.5` is converted into an int
    ```

* **manual** casting when narrowing from larger to smaller compatible data type(risk of data loss/truncation)
  * `double` -> `float` -> `long` -> `int` -> `char` -> `short` -> `byte` -> `char`
    * uses `()` (ie.`(float)`) before the value being assigned to a variable
    * ie. `char ch = (char)65` -> `A`
    * ```java
      // ie. double -> float
      double var1 = 9.78;
      float var2 = (float) var1;//var1 was a double being assigned to var2 which is a float
      ```
#### `String` -> `int`/`double`/`float`
  * since `String` and `int` are not compatible for type casting, must use a function
    * use `Integer.parseInt()` and put the `String` inside the `()`
    ```java
    void main() {
    String var1 = "12345";
    int var2 = Integer.parseInt(var1);
    }           
    ```
    * use `Double.parseDouble()` for `String` -> `double` (ie. `3.14`)
    * use `Float.parseFloat()` for `String` -> `float` (ie. `3.14`)

</details>

***
### variables
<details><summary></summary>

* Must declare type enforcement of variables **ONLY** when intializing variable and/or methods
* may include `final` for constants to enforce immutability
* may include`static` to make variable available to every instance of class
* may include `public` to make variable global to any class within project
* **scope** -> if declared in a loop, it is local (will return in error if attempted to access outside if not declared also outside of loop)
```java
void main() {
    static final double radius = 20;
    double diameter = radius * 2;
    System.out.println("diameter is " + diameter);
}
```
</details>

***
### User input to console
<details><summary></summary>

*Scanners* allow the program to read the console (ie. obtain user input)
* the `Scanner` class must first be set as the data type
* `input` is name of variable
* `new` creates an object for the `Scanner` class
* keyboard input gets passed into `System.in` which the `Scanner` searches for
* the `nextDouble()` method for the `Scanner` class returns the `Double` found in the list
* use `nextLine()` method for String input
```java
import java.util.Scanner;
void main() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter two numbers: ");
    
    double num1 = input.nextDouble();
    double num2 = input.nextDouble();//finds next input separated by space and/or new line
}
```
* use `next()` for scanning for next `String`
* use `nextLine()` for scanning `String` by entire line entered
</details>

***
### Random numbers
<details><summary></summary>

* very similar to a `Scanner` as `Random` is also located in `java.util`
    * `.Random()` -> max range for data type, unless arguments are used ie. `rng.nextInt(11)` -> range is 0-10
```java
import java.util.Random;
void main() {
    Random rng = new Random();//rng is just a variable for the 'Random' object
    double var1 = rng.nextDouble();
    int var2 = rng.nextInt(11);//picks a random int 0-10
}
```

</details>

***
### conditional statements
<details><summary></summary>

* `if` statements contains `()`
* `else if` must be used instead since `elif` does not exist
```java
void main() {
    if (var1 > 0) {
        // statements if true
    } else if (var1 < 0) {
        // statements if true
    } else {
        // statements if false
    }
}
```

#### note!
* `{}` is not technically needed for `else` only for first line after `else`
```java
void main() {
    if (var1 > 0) {
        // statements if true
    } else
        // statements if false
    // OUT OF 'else' SCOPE!
}
```
#### simplified repeating if statements (ie. `if var1 == 5`, `if var1 == 6`, `if var1 == 7`)
* use `switch` and `case`
* ie. `case 1:` checks if `var1` after `switch` is equal to `1`
* may optionally use `default` similar to `else`
```java
void main() {
    int var1 = 8;
    switch (var1) {
      case 1:
          // statements if true
          break;
      case 2:
          // statements if true
          break;
      default:
          // statements if no cases are true
          break;
    }
}
```
#### `break` is used because when any `case` is `true`, it will execute all cases after it
* excluding `break` can be useful in certain circumstances
* may also use `return` on either case as well
```java
void main() {
    int dayOfWeek = 3;
    switch (dayOfWeek) {
      case 1:
      case 2:
      case 3://starts here since case 3 is true
      case 4:
      case 5:
          System.out.println("Weekday");
          break;//ends here
      case 6:
      case 7:
          System.out.println("Weekend");
          break;
    }
}

```
</details>

***
### loops
<details><summary></summary>

* `while` loops very similar to if statements
```java
void main() {
    while (var1 > 0) {
        // statements if true
    } 
}
```
* `do while` loops split the loop in half putting the conditional statement in the middle where the `while` statement is
    * ie. `loop1=true -> do -> while`...`loop2=true -> do -> while`... `loop3=false -> do -> break`
* one benefit is that the statements inbetween the `do` and `while` will be executed at least once. Where a `while` loop by itself may not execute at a>
```java
void main() {
    do {
        // statements to do before while loop
    } while (var1 > 0) {//if false, does not go back to 'do'
        // statements if true
    } 
}
```
* `for` loops syntaxt inside the `()` with `for ()` has three parts
    * for (initialize value of `i`; condition to stop; incrimental direction
        * *initialize* -> ie. `int i = 0` (`i` is 0 on first loop)
        * *condition* -> ie. `i < 10` (will loop 10 times, stop when `i = 10`)
        * *incrimental direction* -> ie. `i++` (incriments 1 every loop)
            * use `i--` for decreasing incriments
```java
void main() {
    for (int i = 0; i < 10; i++) {
    // statements each loop
    }
}
```
* looping through an array
    * it iterate through an array, use the `.length` method without the `()` (ie. `i < myArray.length;`)
    * `i` represents the index, not the item unless using a **for each* loop
      ```java
      for (int i = 0; i < myArray.length; i++) {
          System.out.println(myArray[i]);
      }
      ```
* reverse an array with reverse for loop
    * `j` is set to count backwards while `i` is set to count forwards
        * syntaxt of dual counting for loop: `(i init, j inti; condition; i++, j--)`
    * initialize an empty array, then make `arrayReversed[i] = arrayOriginal[j]`
    ```java
    public static int[] reverseArray(int[] arrayOriginal) {
        int[] arrayReversed = new int[array.length];//initialize empty array
        for (int i = 0, j = arrayOriginal.length-1; i < array.length; i++, j--) {//do not re-declare type of j!
            arrayReversed[j] = array[i];
        }
    ```
* **for each** loop allows pulling the values rather than the index from array ie.`for (double i : myArray)`
    * remember, `i` is just a copy of the value of the index, not the orginal index value
    * ```java
      int sum = 0;
      for (int i : myArray) {
          sum += i;
          //ie. 'i = newValue' will NOT change orginal index value
      }
      ```
</details>

***
### operators
<details><summary></summary>

* common bug if `=` used instead -> `if (var1 = true) {...}` will return `true` always since `var1` is assigned to `true`
* `String` comparison does not work as `==` compares memory addresses (not a problem with number data types like `int`)
    * must use the `.equals()` method for `String` comparison ie. `var1.equals(var2)` instead of `var1 == var2`

* `&&` refers to **and**
* `||` refers to **or**
* `^` referes to **exclusive or** meaning only one can be true

* De Morgan's Law for distributing `!` to a boolean statement
    * flips signs ie. `&&` -> `||` and `<` -> `>=` and `^` -> `==`
    * `!(x > 5 && y < 10)` -> x <= 5 || y >= 10
    * `!(a || b)` -> `!a && !b`
    * `!(a ^ b)` -> `a == b`

* precedence
Java Operator Precedence (highest to lowest)

Precedence | Operators                                          | Description                                                    | Associativity
-----------|----------------------------------------------------|----------------------------------------------------------------|---------------
1 (highest)| ()  []  .  ::                                      | Parentheses, array access, member access, method reference     | Left-to-right
2          | expr++  expr--                                     | Postfix increment/decrement                                    | Left-to-right
3          | ++expr --expr +expr -expr ~ ! (type) new           | Prefix inc/dec, unary +/–, bitwise NOT, logical NOT, cast, new | Right-to-left
4          | *  /  %                                            | Multiplication, division, remainder                            | Left-to-right
5          | +  –                                               | Addition, subtraction (also string concat)                     | Left-to-right
6          | <<  >>  >>>                                        | Bitwise shifts (signed & unsigned)                             | Left-to-right
7          | <  <=  >  >=  instanceof                           | Relational and type comparison                                 | Left-to-right
8          | ==  !=                                             | Equality and inequality                                        | Left-to-right
9          | &                                                  | Bitwise AND                                                    | Left-to-right
10         | ^                                                  | Bitwise XOR                                                    | Left-to-right
11         | \|                                                 | Bitwise OR                                                     | Left-to-right
12         | &&                                                 | Logical AND (short-circuit)                                    | Left-to-right
13         | \|\|                                               | Logical OR (short-circuit)                                     | Left-to-right
14         | ? :                                                | Ternary conditional                                            | Right-to-left
15         | =  +=  -=  *=  /=  %=  &=  ^=  \|=  <<=  >>=  >>>= | Assignment and compound assignment                             | Right-to-left
16 (lowest)| ->                                                 | Lambda expression arrow (context-dependent)                    | —

Notes:
- Operators on the same row have equal precedence.
- Use parentheses () to override precedence and improve readability.
- The arrow operator (->) is used in lambdas and switch expressions and does not follow standard expression precedence rules in all contexts.

</details>

***
### methods
<details><summary></summary>

```java
void main() {
    System.out.println("my method will return: ", methodName(6, 18));
}
public static bool methodName(int param1, int param2) { // need to include bool since this method returns a bool value...the 'int' in the parameters are basically enforced type hints
    // checks if two values are equal
    return (param1 == param2);
}
```
* if argument to an method is an array, must also include `[]` after the type
    ```java
    public static bool methodName(int[] array1) {
    ```
* **stepwise refinement** - top-down stratety, starting with overall goal, then breaking down into smaller tasks
 
#### overloading methods
* lets me have the same method (ie. `max()`) that has different data types for the parameters, or even number of parameters
* the return type is irrelevant

```java
void main() {
    System.out.println("the max int is: ", max(6, 18));
    System.out.println("the max double is: ", max(6.5, 18.6, 5.5));
}
public static int max(int param1, int param2) { 
    // method for 'int' parameters
    if (param1 > param2) return param1;
    return param2
}
public static double max(double param1, double param2, double param3) { 
    // method for 'double' parameters     
    if (param1 > param2) return param1; 
    if (param2 > param3) return param2;
    return param3
}
```
</details>

***
### Arrays
<details><summary></summary>

* Fixed size length
* No hetrogenous types
* created with `new` OR an initializer with `{}`
    * may not use `{}` initializer to replace a previously created array
    * may use `new` to repalce a previously created array
* may use `reportArray()` to print array
* default values
    * zeros for number data types
    * boolean -> false
    * char -> '\u0000' (the "null" character as blank/space)
```java
void main() {
    double[] myArray = new double[10];// creates 10 empyty indexes
    
    myArray[0] = 5.5;//similar to python
    myArray[1] = 2.35;

    string[] ArrayInitializer = {"hello", "world"};

    reportArray(myArray);
    reportArray(ArrayInitializer);
}
```
* to make a copy of an array, can't just simply do `array2 = array1` since that would just make a new variable name for `array1`
    * the simple way: `int[] arrayCopy = myArray.clone();`
    * the manual way: using a `for` loop
        * must first be initialized/created via `new` ie. `int[] copy = new int[original.length];`
    ```java
    int[] original = {1, 2, 3};
    int[] copy = new int[original.length];

    for (int i = 0; i < original.length; i++) {
        copy[i] = original[i];
    }
    ```

</details>

***
### search/sort
<details><summary></summary>

* **linear search**
    ```java
    public static boolean linearSearch(int search) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == search) {
                return true;
            }
        }
        return false;
    }
    ```

* **binary search**
    ```java
    public static boolean binarySearch(int search) {
        int lower = 0;
        int upper = array.length - 1;

        boolean found = false;
        while (!found && lower <= upper) {
            int middle = (lower + upper) / 2;
            if (array[middle] == search) {
                found = true;
            } else if (array[middle] < search) {
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }
        return found;
    }
    ```

* **bubble sort**
    ```java
    public static void bubbleSort(int[] array) {
        boolean didSwap = false;
        do {
            didSwap = false;
            for (int item = 0; item < array.length - 1; item++) {
                if (array[item] > array[item + 1]) {
                    int temp = array[item];
                    array[item] = array[item + 1];
                    array[item + 1] = temp;
                    didSwap = true;
                }
            }
        } while (didSwap);
    }
    ```
    
* **selection sort**
    ```java
    public static void selectionSort(int[] array) {
        for (int start = 0; start < array.length - 1; start++) {
            int minPos = start;
            for (int scan = start + 1; scan < array.length; scan++) {
                if (array[scan] < array[minPos]) {
                    minPos = scan;
                }
            }
            int temp = array[start];
            array[start] = array[minPos];
            array[minPos] = temp;
        }
    }
    ```
</details>

***
### arithmetic
<details><summary></summary>

* post-increment i++ returns current value then increments
    ```java
    int i = 5;
    System.out.println(i++);   // prints 5
    System.out.println(i);     // prints 6
    ```
    ```java
    int a = 10;
    int b = a++;     // b gets 10, then a becomes 11
    System.out.println(a);   // 11
    System.out.println(b);   // 10
    ```
    * incorrect method
        ```java
        int i = 5;
        i = i++;    // i stays 5
        i = i++;    // i stays 5
        i = i++;    // i stays 5
        i = i++;    // i stays 5
        ```
    * correct method
        ```java
        int i = 5;

        i++;          // i → 6
        i++;          // i → 7
        i++;          // i → 8

        // or
        i = i + 1;    // same effect
        i += 1;       // same effect
        ++i;          // same effect (pre-increment)
        ```
* pre-increment ++i increments then returns new value
    ```java
    int x = 3;
    int y = ++x;     // x becomes 4 first, then y gets 4
    System.out.println(x);   // 4
    System.out.println(y);   // 4
    ```
* rounding via `Math.round()` function
    * `float` -> `int` (both are 32 bit numbers)
    a* `double` -> `long` (both are 64 bit nubmers)
</details>

***
### Strings
<details><summary></summary>

* immutable, to find an index use `.charAt(i)` method
* `+=` works for appending
* helpful methods
    * `.toLowerCase()`, `.toUpperCase()`, `.isDigit()`, `.length()`, `.equals(String)`, .`replace(char old, char new)`, `.split(String regex)`, `charAt(int)`, `.substring(int)`
</details>


***
### misc custom functions
<details><summary></summary>

```java
public static boolean areAnagramsSort(String s1, String s2) {
//aTwo strings are anagrams if they contain the same characters with the same frequencies (case-sensitive or insensitive depending on requirement).
    if (s1 == null || s2 == null) return false;
    if (s1.length() != s2.length()) return false;
    
    char[] arr1 = s1.toLowerCase().toCharArray();
    char[] arr2 = s2.toLowerCase().toCharArray();
 a   
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    
    return Arrays.equals(arr1, arr2);
}
```
```java
public static boolean isPalindromeReverse(String s) {
//A string is a palindrome if it reads the same forwards and backwards (ignoring case, spaces, punctuation is optional depending on requirements).
    if (s == null) return false;
    String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    String reversed = new StringBuilder(cleaned).reverse().toString();
    return cleaned.equals(reversed);
}
```
```java
void main() {
    long totalMilliseconds = System.currentTimeMillis();
    
    long totalSeconds = totalMilliseconds / 1000;
    long totalMinutes = totalSeconds / 60;
    long totalHours = totalMinutes / 60;
    
    long currentHour = totalHours % 24;
    long currentMinute = totalMinutes % 60;
    long currentSecond = totalSeconds % 60;
    
    System.out.println("Current time is: "
        + currentHour + ":";
        + currentMinute + ":";
        + currentSecond + "GMT");
}
```
</details>

***
### header
<details><summary></summary>

body
</details>
