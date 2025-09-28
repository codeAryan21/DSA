package Recursion.Backtrack;

// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public static void main(String[] args) {
        char [][]board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void solveSudoku(char [][]board){
        solve(board);
    }

    static boolean solve(char [][]board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){ // empty block found
                    for (char c = '1';c <= '9';c++){ // try with every number
                        if(isValid(board,i,j,c)){  // check if it is safe to place a number if safe then place it
                            board[i][j] = c;
                            if(solve(board)){  // recursive call
                                return true; // solved
                            }else {
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char [][]board,int row,int col,char c){
        for (int i = 0; i < 9; i++) {
            // this is for checking every row
            if(board[row][i] == c){
                return false;
            }
            // this is for checking every col
            if(board[i][col] == c){
                return false;
            }
            // this is for checking every small 3*3 matrix
            int row1 = 3 * (row / 3) + i / 3;
            int col1 = 3 * (col / 3) + i % 3;
            if(board[row1][col1] == c){
                return false;
            }
        }
        return true;
    }
}
