// Blake Hershberger
// 21-JAN-2021
// tells you what o wear

import java.util.Scanner;

public class ClothingPickerWScanner{
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
    if (tempOutsideF < 32) {
      System.out.printf("Wear boots, pants, sweater, and gloves.\n");
    }
    if (tempOutsideF >= 32) {
      System.out.printf("Wear sandals, shorts and a t-shirt, no gloves.\n");
    }
  }
}
