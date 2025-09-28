package BinarySearch.BS1D;

// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// https://leetcode.com/problems/find-peak-element/
public class PeakElement {
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println("The peak element is at index: " + findPeakElement(arr));
        System.out.println("The peak element in the array is: " + findPeak(arr));
    }
    // if you are taking element it should be greater than left element and should be greater than right element
    // arr[i-1] < arr[i] > arr[i+1]
    static int findPeakElement(int []arr) {
        int n = arr.length;

        if(n == 1){
            return 0;
        }
        if(arr[0] > arr[1]){
            return 0;
        }
        if(arr[n-1] > arr[n-2]){
            return n-1;
        }

        int low = 1;
        int high = n-2;
        while (low <= high){
            int mid =  low + (high - low) / 2;

            // If arr[mid] is the peak element
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }

            if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int findPeak(int []arr){
        for (int i = 0; i < arr.length; i++) {
            int n = arr.length;
            if((i == 0 || arr[i-1] < arr[i]) && (i == n-1) || arr[i] > arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }
}
