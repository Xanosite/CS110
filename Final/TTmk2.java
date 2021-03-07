// Blake Hershberger
// 28-FEB-2021
// Tic-Tac-Toe

// imports
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// for any static printing needs
class PrintIt {
  public static void intro() throws IOException, InterruptedException {
    // get the file
    File memeF = new File(System.getProperty("user.dir") + "\\meme.txt");
    Scanner meme = new Scanner(memeF);
    System.out.println("Welcome to a game of Tic-Tac-Toe!");
    Thread.sleep(500);
    System.out.println("Prof Harrison said to not make it.");
    Thread.sleep(500);
    System.out.println("\"It's too hard.\"");
    Thread.sleep(500);
    // print the meme
    while (meme.hasNextLine()) {
      System.out.println(meme.nextLine());
      Thread.sleep(100);
    }
    meme.close();
    Thread.sleep(1000);
    System.out.println("So naturally, here it is! Enjoy?");
    Thread.sleep(500);
  }
}
// class to do grid related things
class ttGrid {
  // data holder
  int[] grid = {0,0,0,0,0,0,0,0,0};

  // setter
  public void setLoc(int loc, int player) {
    grid[loc] = player;
  }

  // getter
  public int getLoc(int loc) {
    return grid[loc];
  }

  // checks for win state, returns 0 if no winner, 1 for comp, 2 for user, 10 for draw
  public int checkWin() {
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

  // looks for two in a row of same type, return location of play or 10 for no play
  public int checkTwo(int player) {
    int notPlayer = 0;
    notPlayer = (player == 1) ? 2 : 1;
    // check for diagonal win/block spot
    if (grid[4] == player) {
      if (grid[0] == 0 && grid[8] == player) {
        return 0;
      } else if (grid[0] == player && grid[8] == 0) {
        return 8;
      } else if (grid[2] == 0 && grid[6] == player) {
        return 2;
      } else if (grid[2] == player && grid[6] == 0) {
        return 6;
      }
    }

    // look for horizontal and vertical 2 in a row
    // check for horizontal and vertical moves layer by layer
    for (int i = 0; i < 3; i++) {
      int countPlayer = 0;
      int countNotP = 0;
      // for each position in the row, count the x's an o's horizontally
      for (int j = 0; j < 3; j++) {
        if (grid[i * 3 + j] == player) {
          countPlayer += 1;
        } else if (grid[i * 3 + j] == notPlayer) {
          countNotP += 1;
        }
      }
      // return move if horizontal win is found
      if (countPlayer == 2 && countNotP == 0) {
        for (int j = 0; j < 3; j++) {
          if (grid[i * 3 + j] == 0) {
            return i * 3 + j;
          }
        }
      }
      countPlayer = 0;
      countNotP = 0;
      // look for vertical win moves
      for (int j = 0; j < 3; j++) {
        if (grid[j * 3 + i] == player) {
          countPlayer += 1;
        } else if (grid[j * 3 + i] == notPlayer) {
          countNotP += 1;
        }
      }
      if (countPlayer == 2 && countNotP == 0) {
        for (int j = 0; j < 3; j++) {
          if (grid[j * 3 + i] == 0) {
            return j * 3 + i;
          }
        }
      }
      countPlayer = 0;
      countNotP = 0;
    }
    return 10;
  }

}

// move all the other methods here for...reasons.
class haveNoStatic {

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

  // converts the grid numbers to display lettters
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
  private static void printGrid(ttGrid grid) throws InterruptedException {
    System.out.println("###################");
    Thread.sleep(75);
    System.out.println("#     #     #     #");
    Thread.sleep(75);
    System.out.println("#  " + numToLetter(grid.getLoc(0)) + "  #  " + numToLetter(grid.getLoc(1)) +
    "  #  " + numToLetter(grid.getLoc(2)) + "  #");
    Thread.sleep(75);
    System.out.println("#  7  #  8  #  9  #");
    Thread.sleep(75);
    System.out.println("###################     X = Player");
    Thread.sleep(75);
    System.out.println("#     #     #     #");
    Thread.sleep(75);
    System.out.println("#  " + numToLetter(grid.getLoc(3)) + "  #  " + numToLetter(grid.getLoc(4)) +
    "  #  " + numToLetter(grid.getLoc(5)) + "  #");
    Thread.sleep(75);
    System.out.println("#  4  #  5  #  6  #");
    Thread.sleep(75);
    System.out.println("###################     O = Computer");
    Thread.sleep(75);
    System.out.println("#     #     #     #");
    Thread.sleep(75);
    System.out.println("#  " + numToLetter(grid.getLoc(6)) + "  #  " + numToLetter(grid.getLoc(7)) +
    "  #  " + numToLetter(grid.getLoc(8)) + "  #");
    Thread.sleep(75);
    System.out.println("#  1  #  2  #  3  #");
    Thread.sleep(75);
    System.out.println("###################");
  }

  // handles all turn based events
  private static int turnCaller(int turn, ttGrid grid, Scanner consoleInput) throws InterruptedException {
    // set next turn
    if (turn == 1) {
      Thread.sleep(500);
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
      Thread.sleep(500);
      System.out.println();
      System.out.println("The computer has chosen to play location " + compLoc);
      Thread.sleep(500);
      System.out.println();
      System.out.println("********************************************");
      return 2;
    } else {
      // player turn
      int playerLoc = 10;
      printGrid(grid);
      while (true) {
        System.out.println("********************************************");
        Thread.sleep(500);
        System.out.println();
        System.out.println("Pick a location to place your \"X\".");
        Thread.sleep(75);
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
          // yell at the user
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
        // update grid location to user identifier (2)
        grid.setLoc(playerLoc, 2);
        break;
      }
      return 1;
    }
  }
  // just tells you who won
  private static void showWinner(ttGrid grid) throws InterruptedException {
    printGrid(grid);
    System.out.println(numToLetter(grid.checkWin()) + " has won the game.");
  }

  public static void runGame() throws IOException, InterruptedException {
    // get the things ready
    Scanner consoleInput = new Scanner (System.in);
    ttGrid grid = new ttGrid();
    Random rand = new Random();

    // decide first turn
    int turn = rand.nextInt(2);

    PrintIt.intro();

    // alternate turns and allow game to progress
    while (grid.checkWin() == 0) {
      turn = turnCaller(turn, grid, consoleInput);
    }
    showWinner(grid);
    consoleInput.close();
  }
}

// driver class
public class TTmk2 {
  public static void main(String[] Args) throws IOException, InterruptedException{
    haveNoStatic.runGame();
  }
}
