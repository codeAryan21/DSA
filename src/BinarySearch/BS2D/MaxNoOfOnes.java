package BinarySearch.BS2D;

public class MaxNoOfOnes {
    public static void main(String[] args) {
        int [][]arr = {
                {0,0,1,1,1},
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,0,0,0,1},
                {0,1,1,1,1}
        };
        int n = arr.length;
        int m = arr[0].length;
        System.out.println("The row with the maximum number of 1's is: " + rowWithMax1s(arr, n, m));

    }

    static int lowerBound(int []arr,int x){
        int low = 0;
        int high = arr.length-1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int rowWithMax1s(int [][]arr,int n,int m){
        int max_count = 0;
        int index = -1;

        // traverse the rows:
        for (int i = 0; i < n; i++) {
            // get the number of 1's:
            int count_ones = m - lowerBound(arr[i],1);
            if(count_ones > max_count){
                max_count = count_ones;
                index = i;
            }
        }
        return index;
    }
}
