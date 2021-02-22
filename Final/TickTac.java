// Blake Hershberger
// 21-FEB-2021
// TicTacToe

// main function()
//  define scanner
//  game loop (endless)
//    calls game engine

// game engine()
//  generate playGrid
//  generate random number for turn order (1 or 0)
//  play intro
//  game loop
//    call turn caller(grid, turn)
//    if winstate checker then break

// turn caller (turn, grid)
//  if turn int is 0, call computer turn and set to  1
//  else call player turn and set to 0

// human turn function(grid)
//  gets user input for play space
//  if valid, allow

// computer turn(grid)
//  call row2 checker comp sign
//    if row2 @ comp sign, finish row
//  else call row2 player sign
//    if row2 @ player sign, block row
//  else if center not taken, take
//  else if not all corners taken, pick corners at random
//  else pick random

// row2 checker(grid, sign)
//  check for 2 in a row of type given, diag, then horiz, then vert

// win state checker(grid)
//  looks for three in a row, either

// printGrid
//   prints grid

import java.util.Scanner;
import java.util.Random;

public class TickTac {
  public static void main(String[] args) {
    // initialize the scanner
    Scanner consoleInput = new Scanner(System.in);
    while (true) {
      gameEngine(consoleInput);
    }
  }

  // the base engine
  private static void gameEngine(Scanner consoleInput) {
    // create grid
    int[] grid = {0,0,0,0,0,0,0,0,0};
    // set random & set initial turn
    Random rand = new Random();
    int turn = rand.nextInt(2);
    // display introduction
    introduction();
    // turn sequencing
    while (winState(grid) == 0) {
      turn = turnCaller(turn, grid, consoleInput, rand);
    }
    System.out.println("Player " + printGridHelper(winState(grid)) + " has won the game");
    printGrid(grid);
    System.out.println("Player " + printGridHelper(winState(grid)) + " has won the game");
    System.out.printf("\n\n");
  }

  // determines the compouters next location
  private static int computerLogic(int[] grid, Random rand) {
    int countX = 0, countO = 0, tempLoc = 0;
    // check for possible diagonal winning move
    if (grid[4] == 1) {
      if (grid[0] == 0 && grid[8] == 1) {
        return 0;
      } else if (grid[0] == 1 && grid[8] == 0) {
        return 8;
      } else if (grid[2] == 0 && grid[6] == 1) {
        return 2;
      } else if (grid[2] == 1 && grid[6] == 0) {
        return 6;
      }
    }
    // check for horizontal and vertical moves layer by layer
    for (int i = 0; i < 3; i++) {
      countO = 0;
      countX = 0;
      // for each position in the row, count the x's an o's horizontally
      for (int j = 0; j < 3; j++) {
        if (grid[i * 3 + j] == 1) {
          countO += 1;
        } else if (grid[i * 3 + j] == 2) {
          countX += 1;
        }
      }
      // return move if horizontal win is found
      if (countO == 2 && countX == 0) {
        for (int j = 0; j < 3; j++) {
          if (grid[i * 3 + j] == 0) {
            return i * 3 + j;
          }
        }
      }
      countO = 0;
      countX = 0;
      // look for vertical win moves
      for (int j = 0; j < 3; j++) {
        if (grid[j * 3 + i] == 1) {
          countO += 1;
        } else if (grid[j * 3 + i] == 2) {
          countX += 1;
        }
      }
      if (countO == 2 && countX == 0) {
        for (int j = 0; j < 3; j++) {
          if (grid[j * 3 + i] == 0) {
            return j * 3 + i;
          }
        }
      }
      countO = 0;
      countX = 0;
      // count horizontal and find win blocking moves
      for (int j = 0; j < 3; j++) {
        if (grid[i * 3 + j] == 1) {
          countO += 1;
        } else if (grid[i * 3 + j] == 2) {
          countX += 1;
        }
      }
      if (countO == 0 && countX == 2) {
        for (int j = 0; j < 3; j++) {
          if (grid[i * 3 + j] == 0) {
            return i * 3 + j;
          }
        }
      }
      countO = 0;
      countX = 0;
      // look for vertical win blocking moves
      for (int j = 0; j < 3; j++) {
        if (grid[j * 3 + i] == 1) {
          countO += 1;
        } else if (grid[j * 3 + i] == 2) {
          countX += 1;
        }
      }
      if (countO == 0 && countX == 2) {
        for (int j = 0; j < 3; j++) {
          if (grid[j * 3 + i] == 0) {
            return j * 3 + i;
          }
        }
      }
      countO = 0;
      countX = 0;
    }
    // check for possible diagonal win blocking move
    if (grid[4] == 2) {
      if (grid[0] == 0 && grid[8] == 2) {
        return 0;
      } else if (grid[0] == 2 && grid[8] == 0) {
        return 8;
      } else if (grid[2] == 0 && grid[6] == 2) {
        return 2;
      } else if (grid[2] == 2 && grid[6] == 0) {
        return 6;
      }
    }
    // pick center if not taken
    if (grid[4] == 0) {
      return 4;
    }
    // pick a random corner if any are free
    if (grid[0] == 0 || grid[2] == 0 || grid[6] == 0 || grid[8] == 0) {
      while (true) {
        tempLoc = rand.nextInt(4);
        switch (tempLoc) {
          case 1 : { tempLoc = 2; break; }
          case 2 : { tempLoc = 6; break; }
          case 3 : { tempLoc = 8; break; }
        }
        if (grid[tempLoc] == 0) {
          return tempLoc;
        }
      }
    }
    // picks a random flat side as last resort because I don't want to do this anymore
    if (grid[1] == 0 || grid[3] == 0 || grid[5] == 0 || grid[7] == 0) {
      while (true) {
        tempLoc = rand.nextInt(4);
        switch (tempLoc) {
          case 0 : { tempLoc = 1; break; }
          case 1 : { tempLoc = 3; break; }
          case 2 : { tempLoc = 5; break; }
          case 3 : { tempLoc = 7; break; }
        }
        if (grid[tempLoc] == 0) {
          return tempLoc;
        }
      }
    }
    return 10;
  }

  // intro sequence
  private static void introduction() {
    System.out.println("Tic-Tac-Toe");
    System.out.println("Presented by: Blake Hershberger");
  }

  // lets the player pick a location
  private static void playerTurn(int[] grid, Scanner consoleInput) {
    int userInput;
    printGrid(grid);
    System.out.print("Please choose a location with the numpad: ");
    // get and verify user input
    while (true) {
      if (consoleInput.hasNextInt()) {
        userInput = consoleInput.nextInt();
      } else {
        System.out.println();
        System.out.println("Please enter a valid integer.");
        if (consoleInput.hasNextLine()) {
          consoleInput.nextLine();
        }
        continue;
      }
      if (userInput < 1 || userInput > 9) {
        if (consoleInput.hasNextLine()) {
          consoleInput.nextLine();
        }
        System.out.println("Please enter a number 1-9.");
        continue;
      }
      if (consoleInput.hasNextLine()) {
        consoleInput.nextLine();
      }
      // translate location enterted into a usable grid index
      switch (userInput) {
        case 7 : { userInput = 0; break; }
        case 8 : { userInput = 1; break; }
        case 9 : { userInput = 2; break; }
        case 4 : { userInput = 3; break; }
        case 5 : { userInput = 4; break; }
        case 6 : { userInput = 5; break; }
        case 1 : { userInput = 6; break; }
        case 2 : { userInput = 7; break; }
        case 3 : { userInput = 8; break; }
      }
      if (grid[userInput] != 0) {
        System.out.println("Please pick a location that is not filled.");
        continue;
      }
      // assign the value of the grid locatio to 2, the player value
      grid[userInput] = 2;
      break;
    }
  }

  // manages the computers turn
  private static void computerTurn(int[] grid, Random rand) {
    int move = computerLogic(grid, rand);
    grid[move] = 1;
    switch (move) {
      case 0 : { move = 7; break; }
      case 1 : { move = 8; break; }
      case 2 : { move = 9; break; }
      case 3 : { move = 4; break; }
      case 4 : { move = 5; break; }
      case 5 : { move = 6; break; }
      case 6 : { move = 1; break; }
      case 7 : { move = 2; break; }
      case 8 : { move = 3; break; }
    }
    System.out.println();
    System.out.println("Computer chose location " + move + ".");
    System.out.println();
  }

// prints the current grid to the screen
  private static void printGrid(int[] grid) {
    System.out.println("###################");
    System.out.println("#     #     #     #");
    System.out.println("#  " + printGridHelper(grid[0]) + "  #  " + printGridHelper(grid[1]) +
    "  #  " + printGridHelper(grid[2]) + "  #");
    System.out.println("#  7  #  8  #  9  #");
    System.out.println("###################     X = Player");
    System.out.println("#     #     #     #");
    System.out.println("#  " + printGridHelper(grid[3]) + "  #  " + printGridHelper(grid[4]) +
    "  #  " + printGridHelper(grid[5]) + "  #");
    System.out.println("#  4  #  5  #  6  #");
    System.out.println("###################     O = Computer");
    System.out.println("#     #     #     #");
    System.out.println("#  " + printGridHelper(grid[6]) + "  #  " + printGridHelper(grid[7]) +
    "  #  " + printGridHelper(grid[8]) + "  #");
    System.out.println("#  1  #  2  #  3  #");
    System.out.println("###################");
  }

// returns print character from numerical value
  private static String printGridHelper(int num) {
    if (num == 1) {
      return "O";
    } else if (num == 2) {
      return "X";
    } else if (num == 10) {
      return "NULL";
    } else {
      return " ";
    }
  }

  // calls player turns
  private static int turnCaller(int turn, int[] grid, Scanner consoleInput, Random rand) {
    if (turn == 0) {
      computerTurn(grid, rand);
      return 1;
    } else {
      playerTurn(grid, consoleInput);
      return 0;
    }
  }

  // determines if a player has won
  private static int winState(int[] grid) {
    // check for winners
    for (int i = 0; i < 3; i++) {
      // horizontal check
      if (grid[i * 3] == grid[i * 3 + 1] && grid[i * 3] == grid[i * 3 + 2]) {
        return grid[i * 3];
      // vertical check
      } else if (grid[i] == grid[i + 3] && grid[i] == grid[i + 6]) {
        return grid[i];
      // diagonal check
      } else if ((grid[4] == grid[0] && grid[4] == grid[8]) || (grid[4] == grid[2] && grid[4] == grid[6])) {
        return grid[4];
      }
    }
    // end game if board is full
    Boolean endFlag = true;
    for (int i = 0; i < 9; i++) {
      if (grid[i] == 0) {
        endFlag = false;
      }
    }
    if (endFlag) {
      return 10;
    }
    // default return (no win) 0
    return 0;
  }
}
