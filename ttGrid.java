// Blake Hershberger
// 28-FEb-2021
// use seperate class for game

public class ttGrid {
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
