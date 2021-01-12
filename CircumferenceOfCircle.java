// Blake Hershberger
// 12-JAN-2021
// Takes radius, returns circumference

// Pseudo
/*
get number from userKeyboard
number * π * 2
return number
*/
import java.util.Scanner;

public class CircumferenceOfCircle {
   public static void main(String[] args) {
      // create an object of type Scanner
      Scanner keyboard = new Scanner(System.in);
      Double radius, diameter, circumference;
      // Ask the user to input a number with decimals
      System.out.print("Enter a decimal number, and press enter  ");
      // scan and assign next double to var radius
      radius = keyboard.nextDouble();
      // close scanner
      keyboard.close();
      // maths
      diameter = 2 * radius;
      circumference = Math.PI * diameter;
      // human interaction
      System.out.println("The circle with radius " + radius +
            " has a circumference of " + circumference);
   }
}
