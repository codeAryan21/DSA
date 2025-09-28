package BinarySearch.Answers;

// https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int []arr = {4,5,6,7};
        System.out.println("The missing number is: " + findKthPositive(arr,6));
        System.out.println("Missing number is: " + missingK(arr,6));
    }

    static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int missingNumber = arr[mid] - (mid  + 1);
            if(missingNumber < k){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return (high + 1 + k); // OR (low + k);
    }


    static int missingK(int []arr,int k){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= k){
                k++;  // shifting k
            }else {
                break;
            }
        }
        return k;
    }
}

/*
int missingNumber = arr[mid] - (mid  + 1);
int more = k - missingNumber
At the end when while loop ends we have to return ( arr[high] + more ) <-- ans
missing = arr[high] - (high  + 1)
more = k - missing
ans = arr[high] + more
ans = arr[high] + k - missing
ans = arr[high] + k - (arr[high] - (high  + 1))
ans = arr[high] + k - arr[high] + (high  + 1)
ans = k + (high  + 1) OR (high + 1 + k) OR (low + k);
*/
