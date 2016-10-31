// filename: TicTacToe.java
//
// This program plays the game of Tic-Tac-Toe with the user.

import java.util.Scanner;

public class TicTacToe
{
  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args)
  {

    //Makes the board a grid of 3 by 3
    final int SIZE = 3;
    char[][] board = new char[SIZE][SIZE]; // game board

    resetBoard(board); // initialize the board (with ' ' for all cells)

    //First lets welcome the user!!! Print a welcome message
    //-------------------------------------------------------------------


    //Now we need to show the board -- what method might come in use here?
    //-------------------------------------------------------------------
    
   
    //Now the user needs to pick what character they want -- "o" or "x"
    //tell them that!! Print out a message
    //-------------------------------------------------------------------


    char userSymbol = sc.next().toLowerCase().charAt(0);
    char compSymbol = (userSymbol == 'x') ? 'o' : 'x';

    //Here are some values we provide you -- turn keeps track of 
    //whose turn it is and remainCount keeps track of the empty
    //spaces
    int turn = 0;  // 0 -- the user, 1 -- the computer
    int remainCount = SIZE * SIZE; // empty cell count

    //Now the user is going to play -- what method might be helpful here? 
    //-------------------------------------------------------------------
    
    //Okay great!!! the user has entered a move -- what do we need to
    //do?
    //-------------------------------------------------------------------

    remainCount--;

    //Okay now we have some variables set up below -- see if you can read
    //the comments to find out what they are used for
    //-------------------------------------------------------------------
    boolean done = false;
    int winner = -1;   // 0 -- the user, 1 -- the computer, -1 -- draw

    //Now we need to continue playing the game -- what do we need to 
    //put in the while loop to do this?? 
    //Hint: You need two things (think about remainCount for one of them)
    //-------------------------------------------------------------------
    while (false /*Replace Me*/ ) {

      //Now that we are "playing" we need to check if the game is "done"
      //what method might help here?
      //-------------------------------------------------------------------
      done = false; //What should done equal to?

      
      //-------------------------------------------------------------------
      //This code checks who was the last one to play and changes the turn
      //read the comments to figure out how this works
      if (done)
        winner = turn; // the one who made the last move won the game
      else {
        // No winner yet.  Find the next turn and play.
        turn = (turn + 1 ) % 2;

      
        //If the turn is 0 then who should play? Call the needed method
        //-------------------------------------------------------------------
        if (turn == 0) {
         
        }

        //If the turn is not 0 (or equal to 1) then who should play?
        //Call the needed method
        //-------------------------------------------------------------------
        else {
        }

        // Show the board after one tic, and decrement the rem count.
        showBoard(board);
        remainCount--;
      }
    }

    //Winner is found!!!!!! Print out a victory message
    //-------------------------------------------------------------------
    if (winner == 0)
      System.out.println("Print me");

    //Player lost :( Print out a message of defeat
    //-------------------------------------------------------------------
    else if (winner == 1)
      System.out.println("Print me");
    
    //Tie!! Print out a message
    //-------------------------------------------------------------------
    else
      System.out.println("Print me");

  }

  public static void resetBoard(char[][] brd)
  {
    for (int i = 0; i < brd.length; i++)
      for (int j = 0; j < brd[0].length; j++)
        brd[i][j] = ' ';
  }

  public static void showBoard(char[][] brd)
  {
    int numRow = brd.length;
    int numCol = brd[0].length;

    System.out.println();

    // First write the column header
    System.out.print("    ");
    for (int i = 0; i < numCol; i++)
      System.out.print(i + "   ");
    System.out.print('\n');

    System.out.println(); // blank line after the header

    // The write the table
    for (int i = 0; i < numRow; i++) {
      System.out.print(i + "  ");
      for (int j = 0; j < numCol; j++) {
        if (j != 0)
          System.out.print("|");
        System.out.print(" " + brd[i][j] + " ");
      }

      System.out.println();

      if (i != (numRow - 1)) {
        // separator line
        System.out.print("   ");
        for (int j = 0; j < numCol; j++) {
          if (j != 0)
            System.out.print("+");
          System.out.print("---");
        }
        System.out.println();
      }
    }
    System.out.println();
  }

  public static void userPlay(char[][] brd, char usym)
  {
    System.out.print("\nEnter the row and column indices: ");
    int rowIndex = sc.nextInt();
    int colIndex = sc.nextInt();

    while (brd[rowIndex][colIndex] != ' ') {
      System.out.print("\n!! The cell is already taken.\nEnter the row and column indices: ");
      rowIndex = sc.nextInt();
      colIndex = sc.nextInt();
    }

    brd[rowIndex][colIndex] = usym;
  }

  public static void compPlay(char[][] brd, char csym)
  {
    // Find the first empty cell and put a tic there.
    for (int i = 0; i < brd.length; i++) {
      for (int j = 0; j < brd[0].length; j++) {
        if (brd[i][j] == ' ') { // empty cell
          brd[i][j] = csym;
          return;
        }
      }
    }
  }

  public static boolean isGameWon(char[][] brd, int turn, char usym, char csym)
  {
    char sym;
    if (turn == 0)
      sym = usym;
    else
      sym = csym;

    int i, j;
    boolean win = false;

    // Check win by a row
    for (i = 0; i < brd.length && !win; i++) {
      for (j = 0; j < brd[0].length; j++) {
        if (brd[i][j] != sym)
          break;
      }
      if (j == brd[0].length)
        win = true;
    }

    // Check win by a column
    for (j = 0; j < brd[0].length && !win; j++) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][j] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // Check win by a diagonal (1)
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // Check win by a diagonal (2)
    if (!win) {
      for (i = 0; i < brd.length; i++) {
        if (brd[i][brd.length - 1 - i] != sym)
          break;
      }
      if (i == brd.length)
        win = true;
    }

    // Finally return win
    return win;
  }
}
