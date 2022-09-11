/*
 * Sudoku Solver
 */

public class F_SudokuSolver {
    // isSafe
    public static boolean isSafe(int sudoku[][],int row,int col,int digit) {
        // column
        for (int i = 0; i <= 8; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }

        // row
        for (int j = 0; j <= 8; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }

        // grid
        int startingRow = (row/3) * 3;
        int startingCol = (col/3) * 3;

        for (int i = startingRow; i <startingRow+3; i++) {
            for (int j = startingCol; j <startingCol+3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        // is True
        return true;
    }

    // Sudoku Solver
    public static boolean sudokuSolver(int sudoku[][], int row , int col) {
        // base case
        if(row == 9) {
            return true;
        }

        // recursion (kaam)
        int nextRow = row;
        int nextCol = col+1;

        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0) { // digit is already placed
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9 ; digit++) {
            if( isSafe(sudoku,row,col,digit) ) {
                sudoku[row][col] = digit;
                if( sudokuSolver(sudoku, nextRow, nextCol) ) { // solution exist
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    // print Sudoku
    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(j%3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(sudoku[i][j]+" ");
            }
            if(i%3 == 2) {
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int sudoku[][] = { {0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3} };

        if( sudokuSolver(sudoku, 0, 0) ) {
            System.out.println("Solution is possible.");
            printSudoku(sudoku);
        }
        else {
            System.out.println("Solution is not possible.");
        }
    }
}
