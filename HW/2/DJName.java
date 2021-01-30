// Author: Blake Hershberger
// Date: 13-JAN-2021
// Takes two string inputs, returns 1/2 each + JayJay

//*****************************************
//*****************************************
// fail input "JaredO"
//*****************************************
//*****************************************

/* Psuedocode
import scanner
// main class & funct
class
  main
    initialize console scanner
    declare firstNameStr, lastNameStr, and outputNameStr
    firstNameStr && lastNameStr = TruncateString( getConsoleInput(firstNameFlag, userTerminal),  firstNameFlag)
    close scanner
    if both first and lastname are one letter, format as initials
    outputNameStr = first + last name
    print result

  GetConsoleInput
    String input
    Boolean cleanInputFlag
    loop until correct
      ask for first / last name as relevant
      get console input
      verify that input is letters, else try again
      Capitalize first letter, lowercase else
      return input

  TruncateString
    auto return input if length is 1
    integers: stringLen = input.length(), start, stop;
    set start stop for fist half of first name, ignore middle if odd
    set start stop for 2nd half of last name, get middle & ignore last if odd
    return desired string
*/

// import area
import java.util.Scanner;

// main class & funct
public class DJName {
  public static void main(String[] args) {
    //declare + initialize scanner of console & declare variables
    Scanner userTerminal = new Scanner(System.in);
    String firstNameStr, lastNameStr, outputNameStr;
    // get & truncate the input from console, nested functions
    firstNameStr = TruncateString(GetConsoleInput(true, userTerminal), true);
    lastNameStr = TruncateString(GetConsoleInput(false, userTerminal), false);
    // close scanner
    userTerminal.close();
    // if both names are single letters after truncation, use them as initials
    // - add decimals and spaces to use as decimals
    if (firstNameStr.length() == 1 && lastNameStr.length() == 1) {
      outputNameStr = firstNameStr + ". " + lastNameStr + ". ";
    } else {
      outputNameStr = firstNameStr + lastNameStr;
    }
    // print result
    System.out.printf("Your DJ name is: %sJayJay", outputNameStr);
  }

  // gets user input, as a string, with only letters, forced cases,
  private static String GetConsoleInput(Boolean firstName, Scanner userTerminal) {
    String input;
    Boolean cleanInputFlag;
    // keep asking until good input is received
    while (true) {
      input = "";
      cleanInputFlag = true;
      // ask first or last name as relevant
      if (firstName) {
        System.out.printf("What is your first name?\n");
      } else {
        System.out.printf("What is your last name?\n");
      }
      //check scanner for input & get if found, else try again
      if (userTerminal.hasNextLine()) {
        input = userTerminal.nextLine();
      } else {
        continue;
      }
      // check if input is letters, yell at user and try again if not
      // input passed hasNextLine() so I do not think it can be length 0
      cleanInputFlag = input.matches("[a-zA-Z]+");
      if (!cleanInputFlag) {
        System.out.printf("Invalid input, please input only letters.\n");
        continue;
      }
      // fail condition for assignment
      if (input.equals("JaredO")) {
        System.exit(0);
      }
      // Capitalize first letter, lowercase else, returns formatted input
      input = input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
      return input;
    }
  }

  // cuts the string into the parts as outlined in instruction set
  private static String TruncateString(String input, Boolean firstName) {
    // auto return input if length is 1
    if (input.length() == 1) { return input; }
    int stringLen = input.length(), start, stop;
    // set start stop for fist half of first name, ignore middle if odd
    // by reducing when it is odd, half is returned if even, and left of half is returned if odd
    if (firstName) {
      if (stringLen % 2 != 0) {
        stringLen--;
      }
      start = 0;
      stop = stringLen / 2;
    // set start stop for 2nd half of last name, get middle & ignore last if odd
    // removing 1 if odd captures the middle character and ignores the last char (shifts left) (-1 for starting at index 0)
    } else {
      if (stringLen % 2 != 0) {
        stringLen--;
      }
      stop = stringLen;
      start = (stringLen / 2) - 1;
    }
    // return desired string
    return input.substring(start, stop);
  }
}
