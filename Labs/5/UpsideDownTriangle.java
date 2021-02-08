// Blake Hershberger
// 8-FEB-2021
// prints "triangle"

import java.util.Scanner;

public class UpsideDownTriangle{
  public static void main(String[] args) {
    //vars and Scanner
    Scanner consoleInput = new Scanner(System.in);
    int triangleHeight;

    //get height, dirty
    System.out.printf("How tall is the triangle?");
    triangleHeight = consoleInput.nextInt();

    // print trianlges, not using i :( )
    for (int row = triangleHeight; row > 0; row--) {
      for (int col = 0; col < row; col++) {
        System.out.print("%");
      }
      System.out.println();
    }
    consoleInput.close();
  }
}
