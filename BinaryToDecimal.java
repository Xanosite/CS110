class BinaryToDecimal {
  public static void main(String[] args) {
    char[] binaryArr = {1,0,1,0,1,1,0,1,0,1,0,1,0,0,1};
    System.out.printf("Binary Input: %s%nInteger Output: %d%n", binaryArrToString(binaryArr), binaryArrToDecimal(binaryArr));
  }
  private static String binaryArrToString(char[] binaryArr) {
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
    int resultInt = 0, i;
    for (i = 0; i < binaryArr.length; i++) {
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
