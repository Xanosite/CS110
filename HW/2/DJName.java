// Author: Blake Hershberger
// Date: 13-JAN-2021
// Takes two string inputs, returns 1/2 eahc + JayJay

// Pseudo
/*
import scanner lib

main function
  get user inputs
  if firstname && lastname lengths are both 1
    call initials handler function with decimal true
  else
    call truncater for any lengths above 0
    call initials handler with decimal false for lengths of 0
  combine strings & JayJay
  print result

input funtion (bool firstname)
  vars: string (input)
  while true
    if firstname == true
      gask for first name
    else
      ask for last name
    prompt input
    if input is not a-z or A-Z
      yell at user
    else
      return input

truncate string function (string: inputString, bool: firstName)
  vars: stringlen
  stringlen = inputString.length
  if firstName == true
    if stringlen % 2 !=0
      stringlen --
    start at position 0
    stop at 1/2 stringlen
  else
    if stringlen % 2 != 0
      stringlen--
    start at 1/2 stringlen - 1
    start = stringlen
  return string.sub(start, stop)

  initials handler function (strng: input, bool decimal, firstname)
  if decimal
    capitalize letter, add a period
  else if firstName
    capitalise letter
  return new str
*/

import java.util.Scanner;

class DJName {
  public static void main(String[] args) {
    //initialize Scanner
    Scanner userKeyboard = new Scanner(System.in);
    // declare and initialize variables
    String firstNameStr = GetInput(true, userKeyboard), lastNameStr = GetInput(false, userKeyboard);
    // deal with single letter entry
    if (firstNameStr.length() == 1 && lastNameStr.length() == 1) {
      firstNameStr = InitialsHandler(firstNameStr, true, true);
      lastNameStr = InitialsHandler(lastNameStr, true, false);
    } else if (firstNameStr.length() == 1) {
      firstNameStr = InitialsHandler(firstNameStr, false, true);
      lastNameStr = TruncateString(lastNameStr, false);
    } else if (lastNameStr.length() == 1) {
      lastNameStr = InitialsHandler(lastNameStr, false, false);
      firstNameStr = TruncateString(firstNameStr, true);
    } else {
      firstNameStr = TruncateString(firstNameStr, true);
      lastNameStr = TruncateString(lastNameStr, false);
    }
    // print result
    System.out.printf("Your DJ name is: %s%sJayJay", firstNameStr, lastNameStr);
    // close scanner
    userKeyboard.close();
  }
  // gets user input, as a string, with only letters, forced cases
  private static String GetInput(Boolean firstName, Scanner userKeyboard) {
    String input;
    Boolean cleanInput;
    int i;

    // keep asking until good input is received
    while (true) {
      input = "";
      cleanInput = true;
      // ask first or last name as relevant
      if (firstName) {
        System.out.printf("What is your first name?\n");
      } else {
        System.out.printf("What is your last name?\n");
      }
      // get input
      input = userKeyboard.nextLine();
      // check if inout is letters
      for (i = 0; i < input.length(); i++) {
        if (!Character.isLetter(input.charAt(i))) {
          cleanInput = false;
        }
      }
      if (!cleanInput) {
        System.out.printf("Invalid input, please input only letters.\n");
        continue;
      }
      // format capitalization values
      input = input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
      // close scanner
      return input;
    }
  }
  // cuts the string into the parts as outlined in instruction set
  private static String TruncateString(String input, Boolean firstName) {
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
  // handles entries with length of 1, makes uppercase if firstName, adds decimals and Spaces if both are single letter
  private static String InitialsHandler (String input, Boolean decimal, Boolean firstName) {
    String ret = input;
    if (decimal) {
      input.toUpperCase();
      ret = input + ". ";
    } else if (firstName) {
      input.toUpperCase();
    }
    return ret;
  }
}
