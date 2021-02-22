// Blake Hershberger
// 21-FEB-2021
// M -> KM and invert

// breaking inputs, anything other than a number for the distnace

import java.util.Scanner;

public class TravelToGermany {
  public static void main(String[] args) {
    // scanner, vars
    Scanner consoleInput = new Scanner(System.in);
    Double distance, retDist;
    String distType;
    // get the unit
    System.out.print("Please enter the distance: ");
    distance = consoleInput.nextDouble();
    consoleInput.nextLine();
    // get UOM
    System.out.println("\"Miles\" or \"Kilometers/KM\"?");
    distType = consoleInput.nextLine();
    // get new val
    retDist = convertDistance(distance, distType);
    // return answer to flesh thing
    if (distance - retDist != 0) {
      System.out.println("Converted value is equal to " + retDist +".");
    }
    // close scanner!
    consoleInput.close();
  }

  // returns the converted value
  public static double convertDistance(double distance, String distanceMeasurement) {
    double retDBL = distance;
    // if string begins with m, it's miles
    if (distanceMeasurement.substring(0,1).equalsIgnoreCase("m")) {
      retDBL *= 1.60934;
    // if it begins with k, its kilometers
  } else if (distanceMeasurement.substring(0,1).equalsIgnoreCase("k")) {
      retDBL *= 0.621371;
    // otherwise it's wrong
    } else {
      System.out.println("I convert miles to kiilometers and vice versa.");
      System.out.println("How will I do that if you dont tell me which it is?");
      System.out.println("Try harder next time.");
    }
    return retDBL;
  }
}
