package BinarySearch.BS1D;

public class UpperBound {
    public static void main(String[] args) { // the smaller index such that number at that index > x; (arr[index] > x);
        int []arr = {2,3,6,7,8,8,10,11,11,12};
        System.out.println("The upper bound is the index: " + upperBound(arr,10));
        System.out.println("The upper bound is the index: " + upperB(arr,6));
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
                // look for smaller index on the left
                high = mid - 1;
            }else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    static int upperB(int []arr,int x){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > x){
                // upper bound found
                return i;
            }
        }
        return arr.length;
    }
}
