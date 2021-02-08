// Blake Hershberger
// 8-Feb-2021
// Draws Triangles

import java.util.Scanner;

public class AsciiTriangle {
  public static void main(String[] args) {
    // vars & scanner
    int triangleHeight = 0;
    String aSCIICharacter = "*";
    Scanner consoleInput = new Scanner (System.in);

    // print instructions, get dirty input
    System.out.println("This program prints a simple ASCII triangle. ");
    System.out.print("How tall should the triangle be?");
    triangleHeight = consoleInput.nextInt() + 1;

    // get character to use, also dirty
    System.out.print("What ASCII character should be used to draw the triangle? ");
    aSCIICharacter = consoleInput.next();

    int triangleRow = 1;
    String triangleRowChars = "";
    int rowCharacterPosition = 1;

    // print ze tri angle
    while (triangleRow < triangleHeight) {
      triangleRowChars = "";
      rowCharacterPosition = 1;
      while (rowCharacterPosition <= triangleRow) {
        triangleRowChars += aSCIICharacter;
        rowCharacterPosition++;
      }
      System.out.println(triangleRowChars);
      triangleRow++;
    }
    consoleInput.close();
  }
}
