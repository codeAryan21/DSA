package Array.Medium;

// https://leetcode.com/problems/rotate-image/description/?envType=problem-list-v2&envId=array
public class RotateArrayBy90 {
    public static void main(String[] args) {
        int [][]matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int [][] ans = rotateBy90(matrix);
        System.out.println("Rotated Image");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] rotateBy90(int [][]matrix){
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse every row
        for (int i = 0; i < n; i++) {
            // row is matrix[i]
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        return matrix;
    }

    /*
    static int[][] rotateBy90(int [][]matrix){
        int n = matrix.length;
        int [][]rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n-i-1] = matrix[i][j];
            }
        }
        return rotated;
    }
     */
}
