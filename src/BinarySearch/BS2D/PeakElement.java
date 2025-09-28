package BinarySearch.BS2D;

import java.util.Arrays;

// https://leetcode.com/problems/find-a-peak-element-ii/description/
public class PeakElement {
    public static void main(String[] args) {
        int [][]matrix = {
                {4,2,5,1,4,5},
                {2,9,3,2,3,2},
                {1,7,6,0,1,3},
                {3,6,2,3,7,2}
        };
        int []ans = findPeak(matrix);
        System.out.println(Arrays.toString(ans));
    }

    static int findMaxIndex(int [][]matrix,int col){
        int maxValue = -1;
        int index = -1;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] > maxValue){
                maxValue = matrix[i][col];
                index = i;
            }
        }
        return index;
    }

    static int[] findPeak(int [][]matrix){
        int n = matrix.length; // row
        int m = matrix[0].length; // col

        int low = 0, high = m-1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int row = findMaxIndex(matrix,mid);
            // if I am standing at mid my left is [mid-1] and right is [mid+1]
            int left = mid-1 >= 0 ? matrix[row][mid-1] : -1;
            int right = mid+1 < m ? matrix[row][mid+1] : -1;

            if(matrix[row][mid] > left && matrix[row][mid] > right){
                return new int[] {row,mid};
            } else if (matrix[row][mid] < left) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return new int[] {-1,-1};
    }
}
