// Blake Hershberger
// 11/3/2021
// Hw6

// get user inout for qty of doubles
// make array
// sum and print array
// avg, max, min of array

// break condition, anything not an int

import java.util.Random;
import java.util.Scanner;

public class simpleArrays {
  // sum and print arr of type double
  private static void sumArr(Double[] arr) {
    // sum array
    Double sum = 0.0;
    for (int i = 0; i < arr.length; i++) { sum += arr[i]; }
    System.out.println("The sum of the array is " + sum);
  }
  // make and print simple greeks from array type double
  private static void greeksArr(Double[] arr) {
    // init
    Double max = 0.0, min = 0.0, avg = 0.0;
    // iterate
    for (int i = 0; i < arr.length; i++) {
      max = (arr[i] > max) ? arr[i] : max;
      min = (arr[i] < min) ? arr[i] : min;
      avg += arr[i];
    }
    avg = avg / arr.length;
    // print things
    System.out.println("The average value is " + avg);
    System.out.println("The highest value is " + max + " and the lowest is " + min);
  }

  public static void main(String[] args) {
    // make things
    Scanner consoleInput = new Scanner(System.in);
    Random rand = new Random();
    int numDoubles = 0;
    // get user input
    System.out.println("How many doubles should I make?");
    numDoubles = consoleInput.nextInt();
    // make array
    Double[] arr = new Double[numDoubles];
    for (int i = 0; i < numDoubles; i++) { arr[i] = rand.nextDouble(); }
    // print sum
    sumArr(arr);
    greeksArr(arr);
    consoleInput.close();
  }
}
