// Blake Hershberger
// 21-JAN-2021
// tells you what o wear

import java.util.Scanner;

public class ClothingPickerIfElse {
  public static void main(String[] args) {
    // variable declaration & scanner init
    Double tempOutsideF;
    // get user input
    Scanner consoleInput = new Scanner(System.in);
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
    consoleInput.close();
    // pick clothing based on temperature
    if (tempOutsideF > 70) {
      System.out.printf("Wear t-shirt, shorts, and sandals.\n");
    } else if (tempOutsideF < 30) {
      System.out.printf("Wear boots, pants, sweater, and gloves.\n");
    } else {
      System.out.printf("Wear long-sleeve shirt, pants, and shoes.\n");
    }
  }
}
