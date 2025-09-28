package Array.Medium;

// https://leetcode.com/problems/set-matrix-zeroes/description/?envType=problem-list-v2&envId=array
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int [][]matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        int [][]ans = setZeroes(matrix);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] setZeroes(int [][]matrix){
        int []row = new int[matrix.length]; // row array
        int []col = new int[matrix[0].length]; // col array

        // Traverse the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    // mark ith index of row with 1
                    row[i] = 1;
                    // mark jth index of col with 1
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0. if row[i] or col[j] is marked with 1.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               if (row[i] == 1 || col[j] == 1){
                   matrix[i][j] = 0;
               }
            }
        }
        return matrix;
    }

    /*
    static int [][] setZeroes(int [][]matrix){
        // int[] row = new int[n]; --> matrix[..][0]
        // int[] col = new int[m]; --> matrix[0][..]
        
        int col0 = 1;
        // step 1: Traverse the matrix and mark 1st row & col accordingly:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    // mark the i-th row
                    matrix[i][0] = 0;
                    // mark the j-th col
                    if(j != 0){
                        matrix[0][j] = 0;
                    }else {
                        col0 = 0;
                    }
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] != 0){
                    // check for row & col
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row
        if(matrix[0][0] == 0){
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
     */
}
