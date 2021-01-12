// Blake Hershberger
// 12-JAN-2021
// Takes radius, returns circumference
import java.util.Scanner;

public class CircumferenceOfCircle {
   public static void main(String[] args) {
      // create an object of type Scanner
      Scanner keyboard = new Scanner(System.in);
      Double radius, diameter, circumference;
      // Ask the user to input a number with decimals
      System.out.print("Enter a decimal number, and press enter  ");
      radius = keyboard.nextDouble();
      keyboard.close();
      diameter = 2 * radius;
      circumference = Math.PI * diameter;
      System.out.println("The circle with radius " + radius +
            " has a circumference of " + circumference);
   }
}
