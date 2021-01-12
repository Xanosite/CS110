//  Author: Blake Hershberger
//  Date: 20210107
//  File: BinaryToDecimal.java

class BinaryToDecimal {
  public static void main(String[] args) {
    // static binary storage for now
    char[] binaryArr = {0,0,0,1,0,0,1,0};
    System.out.printf("Binary Input: %s\nInteger Output: %d%n", binaryArrToString(binaryArr), binaryArrToDecimal(binaryArr));
  }
  private static String binaryArrToString(char[] binaryArr) {
    // converts binary char array (1s and 0s stored in char not as char) and returns string of array
    int i;
    String binaryStr = "";
    for (i = 0; i < binaryArr.length; i++) {
      if (binaryArr[i] == 1) {
        binaryStr += "1";
      } else {
        binaryStr += "0";
      }
    }
    return binaryStr;
  }
  private static int binaryArrToDecimal(char[] binaryArr) {
    // returns decimal value for given char array of 1s and 0s
    int resultInt = 0, i;
    for (i = 0; i < binaryArr.length; i++) {
      // inverts loop order to check from right to left, adds int to return value
      //  if the location contains a 1
      if (binaryArr[(binaryArr.length - 1) - i] == 1) {
        resultInt += power(2, i);
      }
    }
    return resultInt;
  }
  private static int power(int num, int exponent) {
    // (a,b) return a^b
    int i, returnInt = 0;
    // deal with 0 and 1 exponents
    if (exponent == 0) {
      return 1;
    } else if (exponent == 1) {
      return num;
    } else {
      returnInt = num;
    }
    // keep multiplying until exponent is reached
    for (i = 2; i < exponent + 1; i++) {
      returnInt = returnInt * num;
    }
    return returnInt;
  }
}
