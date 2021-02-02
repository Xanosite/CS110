// Blake Hershberger
// 02-FEB-2021
// Does what the name implies

// Code break: "JaredO" as month

// PSEUDO
// Get day / month / year from user
// Check if year is leap year or not
// convert day of month to day of year
// return remaining days in year

import java.util.Scanner;

public class NumberOfDaysLeftInAYear {
  public static void main(String[] args) {
    // init scanner and declare vars
    Scanner userTerminal = new Scanner(System.in);
    int year, month, daysInYear, fullDaysRemain, dayCurrent = 0;
    Boolean leapYearFlag, pluralityFlag, zeroFlag;
    // get the year and check if it's a leap year
    System.out.printf("What year is it? (integer value)\n");
    year = GetConsoleInputInt(userTerminal, false);
    leapYearFlag = IsLeapYear(year);
    // set days in year based on leap bool
    daysInYear = leapYearFlag ? 366 : 365;
    // get month
    System.out.printf("What month is it? (full month name only)\n");
    month = GetConsoleInputInt(userTerminal, true);
    // determine how many days to add based on months past
    // adds days in previous month by falling through all months prior
    switch(month) {
      case 11 : dayCurrent += 30;
      case 10 : dayCurrent += 31;
      case 9 : dayCurrent += 30;
      case 8 : dayCurrent += 31;
      case 7 : dayCurrent += 31;
      case 6 : dayCurrent += 30;
      case 5 : dayCurrent += 31;
      case 4 : dayCurrent += 30;
      case 3 : dayCurrent += 31;
      case 2 : dayCurrent += 28;
      case 1 : dayCurrent += 31;
    }
    // add leap day, if applicable
    if (leapYearFlag && month >= 1) { dayCurrent += 1; }
    // get doy of month
    System.out.printf("What day of the month is it?\n");
    dayCurrent += GetConsoleInputInt(userTerminal, false);
    // find both due to confusing requirement differences
    fullDaysRemain = daysInYear - dayCurrent;
    // kinda pointless flags for output
    pluralityFlag = fullDaysRemain > 1 ? true : false;
    zeroFlag = fullDaysRemain == 0 ? true : false;
    // output
    if (pluralityFlag) {
      System.out.printf("There are %d full days remaining in the year %d.", fullDaysRemain, year);
    } else {
      if (zeroFlag) {
        System.out.printf("There are no full days remaining in the year %d.", year);
      } else {
        System.out.printf("There is one full day remaining in the year %d.", year);
      }
    }
    if (leapYearFlag) {
      System.out.printf(" It is a leap year.");
    } else {
      System.out.printf(" It is not a leap year.");
    }
    userTerminal.close();
  }

  // gets an integer value from user. ONLY an integer AND positive
  private static int GetConsoleInputInt(Scanner userTerminal, Boolean monthFlag) {
    int returnInt = -1;
    String terminalString;
    // loops unitl good input is received
    for (;;) {
      // checks for int, gets int if found
      if (!monthFlag) {
        if (userTerminal.hasNextInt()) {
          returnInt = userTerminal.nextInt();
        }
        // moves cursor past newline
        userTerminal.nextLine();
        // accepts only integers greater than 1
        if (returnInt > 0) {
          break;
        } else {
          System.out.printf("Please enter a positive integer value.\n");
        }
        // gets string from console to turn into a month int
      } else {
        terminalString = userTerminal.nextLine();
        // check if string is alpha, get month (if matches)
        if (terminalString.matches("[a-zA-Z]+")) {
          returnInt = MonthToInt(terminalString);
          if (returnInt >= 0) {
            break;
          }
        }
      // unhappy message when user did not enter a month
      System.out.printf("Please enter the month's full name.\n");
      }
    }
    return returnInt;
  }

  // gets numerical value of month from string value
  private static int MonthToInt(String month) {
    int i, returnInt = -1;
    String tString = month;
    String[] months = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
    //"FAILURE case"
    if (month.equals("JaredO")) { System.exit(0); }
    tString = month.toLowerCase();
    // checks user string for month value, assigns index loc to return
    for(i = 0; i < 12; i++) {
      if (tString.equals(months[i])) {
        returnInt = i;
      }
    }
    return returnInt;
  }

  // checks if the year is a leap year
  private static Boolean IsLeapYear(int year) {
    Boolean retBool = false;
    if ((year % 4) == 0) {
      if ((year % 100) == 0) {
        if ((year % 400) == 0) { retBool = true; }
      } else { retBool = true; }
    }
    return retBool;
  }
}
