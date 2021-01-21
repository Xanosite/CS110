// Blake Hershberger
// 21-JAN-2021
// tells you what o wear

public class WhatDoIWear{
  public static void main(String[] args) {
    // variable declaration
    Double tempOutsideF = 34.0;
    // pick clothing based on temperature
    if (tempOutsideF < 32) {
      System.out.printf("Wear boots, pants, sweater, and gloves.\n");
    }
    if (tempOutsideF > 32) {
      System.out.printf("Wear sandals, shorts and a t-shirt, no gloves.\n");
    }
  }
}
