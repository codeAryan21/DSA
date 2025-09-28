package BinarySearch.BS1D;

public class LowerBound { // the smaller index such that number at that index >= x; (arr[index] >= x);
    public static void main(String[] args) {
        int []arr = {3,5,8,15,19};
        System.out.println("The lower bound is the index: " + lowerBound(arr,2));
        System.out.println("The lower bound is the index: " + lowerB(arr,24));
    }

    static int lowerBound(int []arr,int x){
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


    static int lowerB(int []arr,int x){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= x){
                // lower bound found
                return i;
            }
        }
        return arr.length;
    }
}
