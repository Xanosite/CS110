// Blake Hershberger
// 28-FEB-2021
// Tic-Tac-Toe

// imports
import java.util.Scanner;
import java.util.Random;

public class TTmk2 {

  private static void displayIntro() {
    System.out.println("Tic-Tac-Toe");
    System.out.println("Presented by: Blake Hershberger");
  }

  // handles the computers turn
  private static int computerTurn(ttGrid grid) {
    Random rand = new Random();

    // check if the computer has a wining move available
    int playPos = grid.checkTwo(1);
    if (playPos != 10) {
      grid.setLoc(playPos, 1);
      return playPos;
    }

    // check in the computer can block the player
    playPos = grid.checkTwo(2);
    if (playPos != 10) {
      grid.setLoc(playPos, 1);
      return playPos;
    }

    // take the middle if it is open
    if (grid.getLoc(4) == 0) {
      grid.setLoc(4, 1);
      return 4;
    }

    // if any corners are open, select a random corner
    if (grid.getLoc(0) == 0 || grid.getLoc(2) == 0 || grid.getLoc(6) == 0 || grid.getLoc(8) == 0) {
      while (true) {
        playPos = rand.nextInt(5);
        // reassign two values that aren't corners to be corners
        playPos = (playPos == 1) ? 6 : playPos;
        playPos = (playPos == 4) ? 8 : playPos;
        if (grid.getLoc(playPos) == 0) {
          grid.setLoc(playPos, 1);
          return playPos;
        }
      }
    }

    // pick a random flat
    while (true) {
      playPos = rand.nextInt(5);
      // translate the two nonn flat values into flats
      playPos = (playPos == 0) ? 7 : playPos;
      playPos = (playPos == 2) ? 5 : playPos;
      if (grid.getLoc(playPos) == 0) {
        grid.setLoc(playPos, 1);
        return playPos;
      }
    }
  }

  private static String numToLetter(int num) {
    if (num == 1) {
      return "O";
    } else if (num == 2) {
      return "X";
    } else if (num == 10) {
      return "No one";
    } else {
      return " ";
    }
  }

  // prints the grid
  private static void printGrid(ttGrid grid) {
    System.out.println("###################");
    System.out.println("#     #     #     #");
    System.out.println("#  " + numToLetter(grid.getLoc(0)) + "  #  " + numToLetter(grid.getLoc(1)) +
    "  #  " + numToLetter(grid.getLoc(2)) + "  #");
    System.out.println("#  7  #  8  #  9  #");
    System.out.println("###################     X = Player");
    System.out.println("#     #     #     #");
    System.out.println("#  " + numToLetter(grid.getLoc(3)) + "  #  " + numToLetter(grid.getLoc(4)) +
    "  #  " + numToLetter(grid.getLoc(5)) + "  #");
    System.out.println("#  4  #  5  #  6  #");
    System.out.println("###################     O = Computer");
    System.out.println("#     #     #     #");
    System.out.println("#  " + numToLetter(grid.getLoc(6)) + "  #  " + numToLetter(grid.getLoc(7)) +
    "  #  " + numToLetter(grid.getLoc(8)) + "  #");
    System.out.println("#  1  #  2  #  3  #");
    System.out.println("###################");
  }

  // handles all turn based events
  private static int turnCaller(int turn, ttGrid grid, Scanner consoleInput) {
    // set next turn
    if (turn == 1) {
      // get the comouters location
      int compLoc = computerTurn(grid);
      // translate into user level number
      switch (compLoc) {
        case 0 : { compLoc = 7; break; }
        case 1 : { compLoc = 8; break; }
        case 2 : { compLoc = 9; break; }
        case 3 : { compLoc = 4; break; }
        case 4 : { compLoc = 5; break; }
        case 5 : { compLoc = 6; break; }
        case 6 : { compLoc = 1; break; }
        case 7 : { compLoc = 2; break; }
        case 8 : { compLoc = 3; break; }
      }
      System.out.println("********************************************");
      System.out.println();
      System.out.println("The computer has chosen to play location " + compLoc);
      System.out.println();
      System.out.println("********************************************");
      return 2;
    } else {
      int playerLoc = 10;
      printGrid(grid);
      while (true) {
        System.out.println("********************************************");
        System.out.println();
        System.out.println("Pick a location to place your \"X\".");
        System.out.print("Pick a number, 1-9 as shown: ");
        // get player input
        if (consoleInput.hasNextInt()) {
          playerLoc = consoleInput.nextInt();
          // translate into the array index location
          switch (playerLoc) {
            case 7 : { playerLoc = 0; break; }
            case 8 : { playerLoc = 1; break; }
            case 9 : { playerLoc = 2; break; }
            case 4 : { playerLoc = 3; break; }
            case 5 : { playerLoc = 4; break; }
            case 6 : { playerLoc = 5; break; }
            case 1 : { playerLoc = 6; break; }
            case 2 : { playerLoc = 7; break; }
            case 3 : { playerLoc = 8; break; }
          }
        } else {
          consoleInput.nextLine();
          System.out.println("Please enter a number 1-9. 1");
          continue;
        }
        if (playerLoc < 0 || playerLoc > 8) {
          System.out.println("Please enter a number 1-9. 2");
          continue;
        }
        if (grid.getLoc(playerLoc) != 0) {
          System.out.println("Please pick an open location.");
          continue;
        }
        grid.setLoc(playerLoc, 2);
        break;
      }
      return 1;
    }
  }

  private static void showWinner(ttGrid grid) {
    printGrid(grid);
    System.out.println(numToLetter(grid.checkWin()) + " has won the game.");
  }

  public static void main(String[] args) {
    Scanner consoleInput = new Scanner (System.in);
    ttGrid grid = new ttGrid();
    Random rand = new Random();

    // decide first turn
    int turn = rand.nextInt(2);

    displayIntro();

    // alternate turns and allow game to progress
    while (grid.checkWin() == 0) {
      turn = turnCaller(turn, grid, consoleInput);
    }
    showWinner(grid);
    consoleInput.close();
  }
}
