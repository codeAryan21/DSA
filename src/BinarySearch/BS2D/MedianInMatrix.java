package BinarySearch.BS2D;

import java.util.*;

public class MedianInMatrix {
    public static void main(String[] args) {
        int [][]matrix = {
                {1, 2, 3, 4, 5},
                {8, 9, 11, 12, 13},
                {21, 23, 25, 27, 29}
        };
        System.out.println("The median element is: " + median(matrix));
        System.out.println("Median element in the matrix is: " + findMedian(matrix));
    }

    static int upperBound(int []arr,int x){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high){
            int mid = low + (high - low) / 2;
            // maybe an answer
            if(arr[mid] > x){
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            }else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    // This returns how many are smaller and equals to mid. ( <= mid )
    static int countSmallEqual(int [][]matrix, int x){
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += upperBound(matrix[i],x);
        }
        return count;
    }

    static int findMedian(int [][]matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // point low and high to right elements
        for (int i = 0; i < n; i++) {
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][m-1]);
        }

        int req = (n * m) / 2;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int smallEqual = countSmallEqual(matrix,mid);
            if(smallEqual <= req){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return low;
    }


    static int median(int [][]matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        // Traverse the matrix and copy the elements to the list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(matrix[i][j]);
            }
        }

        // Sort the list
        Collections.sort(list);
        int median = list.get((m * n) / 2);
        return median;
    }
}
