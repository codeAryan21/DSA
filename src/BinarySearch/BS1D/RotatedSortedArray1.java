package BinarySearch.BS1D;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=binary-search
public class RotatedSortedArray1 {
    public static void main(String[] args) {
        int []arr = {4,5,6,7,0,1,2};
        System.out.print("The element is at " + search(arr,1) + " index");
        System.out.print("\nThe element is at " + searchBrute(arr,1) + " index");
    }

    static int search(int []arr,int target){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                return mid;
            }

            // Left part is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && arr[mid] > target){
                    // element exists
                    high = mid - 1;
                }else {
                    // element does not exist
                    low = mid + 1;
                }
            }
            // Right part is sorted
            else {
                if(arr[mid] < target && arr[high] >= target){
                    // element exists
                    low = mid + 1;
                }else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    static int searchBrute(int []arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
