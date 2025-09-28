package BinarySearch.BS1D;

// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class RotatedSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println(search(arr,3));
        System.out.println(searchBrute(arr,3));
    }

    static boolean search(int []arr,int target){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            }

            // Edge case
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            // if left part is sorted
            if(arr[low] <= arr[mid]){
                if(arr[low] <= target && arr[mid] > target){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
            // if right part is sorted
            else{
                if(arr[mid] < target && arr[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    static boolean searchBrute(int []arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }

}
