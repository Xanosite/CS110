// Blake Hershberger
// 14-FEB-2021

// import statements
import java.util.Scanner;

public class MyProgramWithThreeMethods {

    // the main routine
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        int base = 0, power = 0;
        displayInstructions();
        System.out.println("Please input your base; an integer less than 10 : ");
        base = getIntKeyBD(consoleInput);
        System.out.println("Please input your exponent; a positive integer less than 10 : ");
        power = getIntKeyBD(consoleInput);
        // output result
        System.out.println("The integer " + base + " raised to the " + power + "th power: " + iHaveThePower(base, power));
        consoleInput.close();
    }
    public static void displayInstructions() {
      // print to the screen, instructions
      System.out.println("This program calculates the nth power of a base integer input by the user.");
    }
    private static int getIntKeyBD(Scanner consoleInput) {
      System.out.println("Please enter an integer: ");
      int userInput = consoleInput.nextInt();
      consoleInput.nextLine();
      System.out.println("You've supplied " + userInput);
      return userInput;
    }
    private static int iHaveThePower(int base, int power) {
      int ret = 0;
      if (power == 1) { return base; }
      ret = base;
      for (int i = 2; i <= power; i++) {
        ret *= base;
      }
      return ret;
    }
}
