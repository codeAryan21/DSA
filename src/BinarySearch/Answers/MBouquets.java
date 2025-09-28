package BinarySearch.Answers;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MBouquets {
    public static void main(String[] args) {
        int []arr = {7,7,7,7,13,11,12,7};
        int k = 3;
        int m = 2;
        int ans = minDays(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }

    static int findMin(int []arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    static int findMax(int []arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static boolean possible(int []arr,int day,int m,int k){
        int count = 0;
        int noOfBouquets = 0;

        // Count the number of bouquets
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= day){
                count++;
            }else {
                noOfBouquets += (count / k);
                count = 0;
            }
        }
        noOfBouquets += (count / k);
        if (noOfBouquets >= m){
            return true;
        }
        return false;
    }

    // m = no. of bouquets , k = adjacent flower required
    static int minDays(int []arr,int m,int k){
        // Impossible case.
        if(m*k > arr.length){
            return -1;
        }
        int low = findMin(arr);
        int high = findMax(arr);

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (possible(arr,mid,m,k)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

}
