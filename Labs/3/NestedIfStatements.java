// Blake Hershberger
// 21-JAN-2021
// tells you what o wear

import java.util.Scanner;

public class NestedIfStatements {
  public static void main(String[] args) {
    // variable declaration & scanner init
    int rainInt;
    Double tempOutsideF;
    Boolean rainBool;
    Scanner consoleInput = new Scanner(System.in);
    // ask for temp
    while (true) {
      System.out.printf("What temperature is it outside: ");
      if (consoleInput.hasNextDouble()) {
        tempOutsideF = consoleInput.nextDouble();
        System.out.printf("\n");
        break;
      } else {
        System.out.printf("\n");
        consoleInput.nextLine();
      }
    }
    // ask if rain, set bool
    while (true) {
      System.out.printf("Is it raining? 1 for yes, 0 for no: ");
      if (consoleInput.hasNextInt()) {
        rainInt = consoleInput.nextInt();
      } else {
        continue;
      }
      if (rainInt == 1) {
        rainBool = true;
        consoleInput.nextLine();
        break;
      } else if (rainInt == 0) {
        rainBool = false;
        consoleInput.nextLine();
        break;
      }
    }
    consoleInput.close();
    // pick clothing based on temperature
    if (tempOutsideF > 70) {
      System.out.printf("Wear t-shirt, shorts, and sandals, ");
      // umbrella or sunglasses?
      if (rainBool) {
        System.out.printf("and bring an umbrella.\n");
      } else {
        System.out.printf("and bring sunglasses.\n");
      }
    } else if (tempOutsideF < 30) {
      System.out.printf("Wear boots, pants, sweater, and gloves, ");
      // umbrella or sunglasses?
      if (rainBool) {
        System.out.printf("and bring an umbrella.\n");
      } else {
        System.out.printf("and bring sunglasses.\n");
      }
    } else {
      System.out.printf("Wear long-sleeve shirt, pants, and shoes, ");
      // umbrella or sunglasses?
      if (rainBool) {
        System.out.printf("and bring an umbrella.\n");
      } else {
        System.out.printf("and bring sunglasses.\n");
      }
    }
  }
}
