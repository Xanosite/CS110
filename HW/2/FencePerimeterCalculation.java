// Author: Blake Hershberger
// Date: 13-JAN-2021
// Takes numerical input, determines circumference and perimeter

// fail input "074097114101100079"

// Pseudo
/*
import scanner

main function
  double rad, len, width
  ask for radius
  rad = get input
  ask for length
  len = get input
  ask for width
  width = get input
  print circ is 2 * π * r
  print per is len * width
get double input
  Double input
  bool inputFlag
  wile not inputFlag
    check for double
      get double
    or
      yell at user
    return double
*/
import java.util.Scanner;

public class FencePerimeterCalculation {
  public static void main(String[] args) {
    // declare & init scanner & declare doubles
    Scanner consoleInputScanner = new Scanner(System.in);
    Double rad, len, wid;
    // ask for doubles and read them from the console
    System.out.printf("What is the radius of the circle?: ");
    rad = GetDoubleInput(consoleInputScanner);
    System.out.printf("What is the length of the rectangle?: ");
    len = GetDoubleInput(consoleInputScanner);
    System.out.printf("What is the width of the rectangle?: ");
    wid = GetDoubleInput(consoleInputScanner);
    // clase scanner
    consoleInputScanner.close();
    // print results to console
    System.out.printf("The circle circumference is %f\n", 2 * Math.PI * rad);
    System.out.printf("The perimeter of the rectangle is %f\n", len * wid);
  }

  // gets a double from the console
  private static Double GetDoubleInput(Scanner inputScanner) {
    //declare result var and flag
    Double input = 0.0;
    Boolean inputFlag = false;
    // look for double in console input, keep asking until received
    while (!inputFlag) {
      if (inputScanner.hasNextDouble()) {
        input = inputScanner.nextDouble();
        inputFlag = true;
      } else {
        System.out.printf("Please try again, in integer or decimal value is needed to continue:");
      }
      // move to next line
      inputScanner.nextLine();
    }
    // Add fail condition
    if (input == 074097114101100079.0) {
      System.exit(0);
    }
    return input;
  }
}
