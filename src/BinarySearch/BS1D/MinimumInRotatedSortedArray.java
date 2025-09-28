package BinarySearch.BS1D;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,1,3};
        System.out.println("The minimum element is: " + findMin(arr));
        System.out.println("The minimum element is: " + findMinimum(arr));
    }

    static int findMin(int []arr){
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high){
            int mid = low + (high - low) / 2;

            //if the entire array is already sorted then arr[low] will always be the minimum in that array
            if(arr[low] <= arr[high]){
                min = Math.min(min,arr[low]);
                break;
            }

            // for the duplicates
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            // if left part is sorted
            if(arr[low] <= arr[mid]){
                // keep the minimum
                min = Math.min(min,arr[low]);
                // Eliminate left half
                low = mid + 1;
            }
            // if right part is sorted
            else {
                // keep the minimum
                min = Math.min(min,arr[mid]);
                // Eliminate right half
                high = mid - 1;
            }
        }
        return min;
    }

    static int findMinimum(int []arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
