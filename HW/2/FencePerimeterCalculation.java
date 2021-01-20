// Author: Blake Hershberger
// Date: 13-JAN-2021
// Takes numerical input, determines circumference and perimeter

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
*/
import java.util.Scanner;

public class FencePerimeterCalculation {
  // only need main for this one
  public static void main(String[] args) {
    // declare && init scanner
    Scanner consoleInputScanner = new Scanner(System.in);
    // declare var
    Double rad, len, wid;
    // ask
    System.out.printf("What is the radius of the circle?: ");
    // read
    rad = GetDoubleInput(consoleInputScanner);
    // ask
    System.out.printf("What is the length of the rectangle?: ");
    // read
    len = GetDoubleInput(consoleInputScanner);
    // ask
    System.out.printf("What is the width of the rectangle?: ");
    // read
    wid = GetDoubleInput(consoleInputScanner);
    // tell
    System.out.printf("The circle circumference is %f\n", 2 * Math.PI * rad);
    System.out.printf("The perimeter of the rectangle is %f\n", len * wid);
    // clase scanner (memory)
    consoleInputScanner.close();
  }

  // gets a double from the console
  private static Double GetDoubleInput(Scanner inputScanner) {
    //declare result var
    Double input = 0.0;
    Boolean inputFlag = false;
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
    return input;
  }
}
