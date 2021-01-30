//import scanner
import java.util.Scanner;

public class DecimalMathUsingIntegers {

  // main
  public static void main (String[] args) {

    //declare and assign variables
    int wholePart = 0, fractionalPart = 0;
    double composedDecimalValue = 0.0;
    Scanner consoleInput = new Scanner(System.in);

    // instruct user & get input
    System.out.print("Input an integer for digits left of the decimal: ");
    wholePart = consoleInput.nextInt();
    System.out.print("Input an integer >= 10 for digits right of the decimal: ");
    fractionalPart = consoleInput.nextInt();

    //output status message and calculation
    System.out.println("The wholePart variable has the value: " + wholePart);
    System.out.println("The fractionalPart has the variable: " + fractionalPart);
    composedDecimalValue = wholePart + fractionalPart / 100.0;
    System.out.println("The composedDecimalValue is: " + composedDecimalValue);

    //multiply and display
    System.out.printf("The formatted composedDecimalValue times 10,000 is %,.6f \n", (composedDecimalValue * 10000.0));
  }
}
