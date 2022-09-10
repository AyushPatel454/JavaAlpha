/*
 * N-Queens Problem
 * 
 * print all safest solution of n-quees. (Queens can't attck to each other)
 */

public class Db_nQueens {
    // is Safe ?
    public static boolean isSafe(char board[][],int row, int col) {
        // vertical-up
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left - up
        for (int i = row-1 , j = col-1; i >= 0 && j>=0 ; i-- , j--) {
            if(board[i][j] == 'Q') {
                return false;
            }            
        }
        // diagonal right - up
        for (int i = row-1 , j = col+1 ; i >= 0 && j < board.length; i-- , j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // queen is safe
        return true;
    }

    // n-queen
    public static void nQueens(char board[][],int row) {
        // base case
        if(row == board.length) {
            printBoard(board);
            return;
        }
        // column loop
        for (int j = 0; j < board.length; j++) {
            if( isSafe(board,row,j) ) {
                board[row][j] = 'Q';
                nQueens(board, row+1); // function call
                board[row][j] = 'x'; // backtracking step
            }
        }
    }

    // print board
    public static void printBoard(char board[][]) {
        System.out.println("------------- Chess board -------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }

        nQueens(board, 0);
    }
}
