// Author: Blake Hershberger
// Date: 12-JAN-2021
// Takes two string inputs, returns 1/2 eahc + JayJay

// Pseudo
/*
import scanner lib

main function
  vars string string1, string2
  string 1 = stringtruncate(input(true), true)
  string 2 = stringtruncate(input(false), false)
  printf("Your DJ name is: %s%sJayJay", string1, string2)

input funtion (bool firstname)
  vars: string (input)
  while true
    if firstname == true
      printf("What is your first name?\n");
    else
      printf("What is your last name?\n");
    prompt input
    if input is not a-z or A-Z
      yell at user
    else
      return input

string truncate function (string: inputString, bool: firstName)
  vars: stringlen, cutString, i, start
  stringlen = inputString.length
  if firstName == true
    if stringlen % 2 !=0
      stringlen --
    stringlen = stringlen / 2
    start = 0
  else
    if stringlen % 2 != 0
      stringlen--
    stringlen = stringlen / 2
    start = stringlen
  for (i = 0; i < stringlen; i++)
    cutString.append(inputString(i + start))
  return cutString
*/

import java.util.Scanner;

class DJName {
  public static void main(String[] args) {
    //initialize Scanner
    Scanner userKeyboard = new Scanner(System.in);
    System.out.printf("Your DJ name is: %s%sJayJay", TruncateString(GetInput(true, userKeyboard), true), TruncateString(GetInput(false, userKeyboard), false));
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
    if (firstName) {
      if (stringLen % 2 != 0) {
        stringLen--;
      }
      start = 0;
      stop = stringLen / 2;
    // set start stop for 2nd half of last name, get middle & ignore last if odd
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
