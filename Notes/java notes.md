<details>
<summary><h3>Java pre-25 version</h3></summary>

This program demonstrates the simplified "Implicitly Declared Class" syntax available in Java 25.
#### Java 25:
```java
void main() {
    System.out.println("Hello, World!");
}
```
where the old method would require setting up a class and declaring both the class and the method as public. If public is not declared it is private however Java25 ad an exception allowing the JVM to run the main method
#### Java 21:
```java
public class main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

```
</details>

***
<details>
<summary><h3>signature</h3></summary>

* `static` means the method it tied directly to the class without an instance/object
* the `String[] args` is for entering arguments when running the program even if no arguments are used.
</details>

***
<details>
<summary><h3>printing to console</h3></summary>

the `ln` in `println`  adds a new line after the print.
```java
public class main {
    public static void main(String[] args) {
        System.out.print("Hello");
        System.out.println(" World!");
    }
}
```
#### output:
```
Hello World!
```
</details>

***
<details>
<summary><h3>format fields</h3></summary>

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
    void main () {
        String var1 = "Number PI is:";
        double num1 = 3.14159;
        System.out.println("Number PI is:" + num1);//output: "Number PI is:3.14159"
        System.out.printf("%.6s %6.2f", var1, num1);//output: "PI is:   3.14"   
    }
    ```
</details>

***
<details>
<summary><h3>data types</h3></summary>
* `double` is similar to a `float` but twice as accurate up to 15-16 decimal places instead of 7 for a `float`
* `long` is similar to an `int` but it can store a 64bit number instead of 32bit number.
  * `long` values must contain the suffix `L` at the end (ie. `var1 = 45623214L`)
* `char` can be any single Unicode character
  * enclosed in single quotes (`'A'`)
* `String` is enclosed in double quotes (`"A"`)
  * behaves same as Python with concatenation and assignment
***
</details>

***
<details>
<summary><h3>type casting</h3></summary>

* **automatic** when widening from smaller type to larger
  * `byte` -> `short` -> `char` -> `int` -> `long` -> `float` -> `double`

* **manual** casting when narrowing from larger to smaller compatible data type(risk of data loss/truncation)
  * `double` -> `float` -> `long` -> `int` -> `char` -> `short` -> `byte`
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
    void main (){
    String var1 = "12345";
    int var2 = Integer.parseInt(var1);
    }           
    ```
    * use `Double.parseDouble()` for `String` -> `double` (ie. `3.14`)
    * use `Float.parseFloat()` for `String` -> `float` (ie. `3.14`)

</details>

***
<details>
<summary><h3>variables</h3></summary>

* Must **always** declare type enforcement of variables
* may include `final` for constants to enforce immutability
* may include`static` to make variable available to every instance of class
* may include `public` to make variable global to any class within project
```java
void main() {
    static final double radius = 20;
    double diameter = radius * 2;
    System.out.println("diameter is " + diameter);
}
```
</details>

***
<details>
<summary><h3>User input to console</h3></summary>

*Scanners* allow the program to read the console (ie. obtain user input)
* the `Scanner` class must first be set as the data type
* `input` is name of variable
* `new` creates an object for the `Scanner` class
* keyboard input gets passed into `System.in` which the `Scanner` searches for
* the `nextDouble()` method for the `Scanner` class returns the `Double` found in the list
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
<details>
<summary><h3>Current time</h3></summary>

similar to python, gets time in GMT time using `System.currentTimeMillis()`
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
        + currentHour + ":"
        + currentMinute + ":"
        + currentSecond + "GMT");
    
}
```
</details>

***
<details>
<summary><h3>conditional statements</h3></summary>

* `if` statements contains `()`
* `else if` must be used instead since `elif` does not exist
```java
void main () {
    if (var1 > 0) {
        // statements if true
    } 
    else if (var1 < 0) {
        // statements if true
    } 
    else {
        // statements if false
    }
}
```
#### note
* `{}` is not technically needed for `else` only for first line after `else`
```java
void main () {
    if (var1 > 0) {
        // statements if true
    } 
    else
        // statements if false
    // OUT OF 'else' SCOPE!
}
```
#### simplified repeating if statements (ie. `if var1 == 5`, `if var1 == 6`, `if var1 == 7`)
* use `switch` and `case`
* ie. `case 1:` checks if `var1` after `switch` is equal to `1`
* may optionally use `default` similar to `else`
```java
void main () {
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
```java
void main () {
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
<details>
<summary><h3>comparison operators</h3></summary>

* `String` comparison does not work as `==` compares memory addresses (not a problem with number data types like `int`)
* must use the `.equals()` method for `String` comparison ie. `var1.equals(var2)` instead of `var1 == var2`
</details>

***
<details>
<summary><h3>escape sequences</h3></summary>

* same as python ie. `\"` `\\` `\n` `\t`
</details>

***
<details>
<summary><h3>header</h3></summary>

body
</details>