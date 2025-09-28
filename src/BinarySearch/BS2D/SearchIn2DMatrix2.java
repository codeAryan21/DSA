package BinarySearch.BS2D;

import java.util.Arrays;
//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class SearchIn2DMatrix2 {
    public static void main(String[] args) {
        int [][]matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int []ans = searchMatrix(matrix,5);
        System.out.println(Arrays.toString(ans));

        System.out.println(searchMatrix1(matrix,14));
    }

    static int[] searchMatrix(int [][]matrix,int target){
        int n = matrix.length; // row
        int m = matrix[0].length; // col

        int row = 0, col = m-1;
        // traverse the matrix from (0, m-1)
        while (row < n && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row,col};
            } else if (matrix[row][col] > target) {
                col--;
            }else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }

    // this is for returning the boolean value, the target is present in the matrix or not
    static boolean searchMatrix1(int [][]matrix,int target){
        int n = matrix.length; // row
        int m = matrix[0].length; // col

        int row = 0, col = m-1;
        // traverse the matrix from (0, m-1)
        while (row < n && col >= 0){
            if(matrix[row][col] == target){
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
