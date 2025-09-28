package BinarySearch.BS1D;

// https://leetcode.com/problems/search-insert-position/description/?envType=problem-list-v2&envId=binary-search
public class SearchInsertPosition {
    public static void main(String[] args) {
        int []arr = {1,3,5,6};
        System.out.println("The index is: " + searchInsert(arr, 5));
    }

    static int searchInsert(int []arr,int x){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high){
            int mid = low + (high - low) / 2;
            // maybe an answer
            if(arr[mid] >= x){
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            }else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
