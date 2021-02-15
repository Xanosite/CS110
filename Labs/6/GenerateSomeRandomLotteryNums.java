//  Blake Hershberger
//  14-FEB-2021
//  guesses numbers i guess

import java.util.Scanner;
import java.util.Random;

public class GenerateSomeRandomLotteryNums {
  public static void main(String[] args) {
    // vars and Scanner and rand
    Scanner consoleInput = new Scanner(System.in);
    int tries = 0, maxNum = 0;
    Random rnd = new Random();
    // print to screen
    System.out.println("I know you are busy, so I will guess");
    System.out.println("your lottery numbers for you!");
    System.out.println("How many numbers should I guess?");
    // get tries
    tries = consoleInput.nextInt();
    consoleInput.nextLine();
    // speak
    System.out.println("What is the highest possible lottery number?");
    // get maxNum
    maxNum = consoleInput.nextInt();
    consoleInput.nextLine();

    // guessing game
    for (int i = 0; i < tries; i++) {
      int randomNum = rnd.nextInt(maxNum);
      if (i == 0) {
        System.out.println("The first lottery Number is " + randomNum);
      } else if (i == tries - 1) {
        System.out.println("The last lottery Number is " + randomNum);
      } else {
        System.out.println("The next lottery Number is " + randomNum);
      }
    }
  }
}
