package Array.Medium;

import java.util.*;

// https://leetcode.com/problems/spiral-matrix/?envType=problem-list-v2&envId=array
public class SpiralMatrix {
    public static void main(String[] args) {
        int [][]matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        List<Integer> ans = printSpiral(matrix);
        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

    // right -> bottom -> left -> top
    static List<Integer> printSpiral(int [][]matrix){
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length; // no. of rows
        int m = matrix[0].length; // no. of columns

        // there 4 pointers are required for traversal
        int top = 0,bottom = n-1,left = 0,right = m-1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right){
            // For moving left to right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

}