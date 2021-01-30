// Blake Hershberger
// Lab 4 part 2
// 30JAN2021

// PSEUDO
// Get user int input
// display int related message
//     9 cases for switch
//     can have a default
//     7 print messages only

import java.util.Scanner;

public class OneThroughNine {
  public static void main(String[] args) {
    //var & scanner
    int userInteger;
    Scanner consoleInput = new Scanner(System.in);

    while (true) {
      // get user input
      System.out.printf("Please enter an integer 1-9: ");
      if (!consoleInput.hasNextInt()) {
        consoleInput.nextLine();
        continue;
      }
      userInteger = consoleInput.nextInt();
      consoleInput.nextLine();
      // inform the user about these fun integer facts
      switch(userInteger) {
        case 1:
          System.out.printf("1 can be written as 1*1, thus it has two factors, but they both are not different and hence it is not a prime number.\n");
          break;
        case 2:
          System.out.printf("2 is the only prime number that is even and it is the smallest prime number.\n");
          break;
        case 3,9:
          System.out.printf("3 squared is 9, and the square root of 9 is 3.\n");
          break;
        case 4:
          System.out.printf("4 is the smallest square greater than 1.\n");
          break;
        case 5:
          System.out.printf("5 is a half of 10. Wow!\n");
          break;
        case 6:
          System.out.printf("6 is the smallest number that is equal to the sum of its proper divisors. Interesting!\n");
          break;
        case 7,8:
          System.out.printf("The numbers 7 and 8 are both less than 9. Amazing!\n");
          break;
      }

    }
  }
}
