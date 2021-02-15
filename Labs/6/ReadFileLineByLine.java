//  Blake Hershberger
//  14-FEB-2021
//  Reads a file, prints simpson characters

import java.util.Scanner; // Import the Scanner class
import java.io.*;         // Import Java I/O classes

// Define a new class
public class ReadFileLineByLine {

    // the main method
    public static void main (String[] args) throws IOException{

   	// Important: make sure that you have retrieved the file
   	// TerraceEverVerdant.txt from the Canvas' File->labs->lab6, and that
   	// you have saved that file into your lab6 folder.

   	// 1. declare a variable, myFileName, of type String, and assign
   	// it the value ReadFileLineByLine.txt

      String myFileName = "ReadFileLineByLine.txt";

   	// 2. declare a variable, myFile, of type File, and
   	// assign it to be a new instance of the File class,
   	// and give the File class constructor the variable
   	// myFileName as the single argument

      File myFile = new File(myFileName);

   	// 3. declare a variable, inputFile, of type Scanner,
   	// and assign it to be a new instance of the Scanner
   	// class, and give the Scanner class constructor
   	// the variable myFile as the single argument

      Scanner inputFile = new Scanner(myFile);

   	// 4. declare a variable, loopNumber, of type int, and
   	// assign it the value 0

      int loopNumber = 0;

   	// 5. use a while loop, whose conditional is the following:
   	//
   	// inputFile.hasNext()
   	//
   	// At each iteration of the while loop:
   	//
   	// a. increment loopNumber by 1
   	// b. declare variable fileLine as a String, and
   	//    assign it the value inputFile.nextLine();
   	// c. write an if statement, that checks if
   	//    loopNumber modulus 7 is equal to zero; if it is
   	//    then use System.out.println to print to the
   	//    screen the value stored in fileLine

      while(inputFile.hasNext()) {
        loopNumber++;
        String fileLine = inputFile.nextLine();
        if (loopNumber % 7 == 0) { System.out.println(fileLine); }
      }

   	// 6. close the file

      inputFile.close();
    }
}
