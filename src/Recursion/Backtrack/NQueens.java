package Recursion.Backtrack;

import java.util.*;

// https://leetcode.com/problems/n-queens/description/
public class NQueens {
    public static void main(String[] args) {
        int N = 4;
        List<List<String>> ans = solveNQueens(N);

        for (int i = 0; i < ans.size(); i++) {  // iterate over the ans
            List<String> board = ans.get(i);
            for (int j = 0; j < board.size(); j++) {  // iterate over rows
                System.out.println(board.get(j));
            }
            System.out.println();
        }
    }

    static List<List<String>> solveNQueens(int n) {
        char [][]board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // fill row with '.'
            }
        }
        List<List<String>> ans = new ArrayList<>();
        int []leftRow = new int[n];
        int []upperDiagonal = new int[2 * n - 1];
        int []lowerDiagonal = new int[2 * n - 1];
        solve(0,board,leftRow,upperDiagonal,lowerDiagonal,ans);
        return ans;
    }

    static void solve(int col,char [][]board,int []leftRow,int []upperDiagonal,int []lowerDiagonal,List<List<String>> list){
        if (col == board.length){
            list.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + (col - row)] == 0){
                // place queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[(board.length - 1) + (col - row)] = 1;

                // recursive call for next column
                solve(col+1,board,leftRow,upperDiagonal,lowerDiagonal,list);

                // backtrack
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[(board.length - 1) + (col - row)] = 0;
            }
        }
    }

    static List<String> construct(char [][]board){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            list.add(s);
        }
        return list;
    }
}
