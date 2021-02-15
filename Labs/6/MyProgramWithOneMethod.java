// import statements
import java.util.Scanner;

public class MyProgramWithOneMethod {

    // the main routine
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);
        int base = 0, power = 0, result = 0;
        displayInstructions();
        System.out.println("Please input your base; an integer less than 10 : ");
        base = consoleInput.nextInt();
        consoleInput.nextLine();
        System.out.println("Please input your exponent; a positive integer less than 10 : ");
        power = consoleInput.nextInt();
        consoleInput.nextLine();
        // output result
        result = base;
        if (!(power == 1)) {
          for (int i = 2; i <= power; i++) {
            result *= base;
          }
        }
        System.out.println("The integer " + base + " raised to the " + power + "th power: " + result);
        consoleInput.close();
    }
    public static void displayInstructions() {
      // print to the screen, instructions
      System.out.println("This program calculates the nth power of a base integer input by the user.");
    }
}
