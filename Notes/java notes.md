### Java pre-25 version

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
***
### signature
* `static` means the method it tied directly to the class without an instance/object
* the `String[] args` is for entering arguments when running the program even if no arguments are used.
***
### printing to console
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
***
### data types
* `double` is similar to a `float` but twice as accurate up to 15-16 decimal places instead of 7 for a `float`
* `long` is similar to an `int` but it can store a 64bit number instead of 32bit number.
  * a `long` value must contain the suffix `L` at the end (ie. `var1 = 45623214L`)
***
### variables
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
***
### User input to console
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
    System.out.print("Enter a number for a radius: ");
    
    double radius = input.nextDouble();
    double area = radius * radius * 3.14159;
    
}
```
***
### current time
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
---
### conditional statements
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

---
### comparison operators 
* `string` comparison does not work as `==` compares memory addresses
* must use the `.equals()` method for `string` comparison ie. `var1.equals(var2)` instead of `var1 == var2`