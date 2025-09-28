package BinarySearch.BS2D;

// https://leetcode.com/problems/search-a-2d-matrix/description/
public class SearchIn2DMatrix1 {
    public static void main(String[] args) {
        int [][]matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(searchMatrix(matrix,8));
    }

    static boolean searchMatrix(int [][]matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = (n * m) - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }
}

/*
convert the 1D coordinates to 2D coordinates
If u have index the formula to convert it is:-
row = index / m ( where m is the number of columns )
col = index % m
*/
