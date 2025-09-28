package BinarySearch.Answers;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class ShipPackageCapacityWithinDdays {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        int ans = leastWeightCapacity(arr, 5);
        System.out.println("The minimum capacity should be: " + ans);
    }

    static int findDays(int []arr,int capacity){
        int days = 1;
        int loadCapacity = 0;

        for (int i = 0; i < arr.length; i++) {
            if(loadCapacity + arr[i] > capacity){
                days += 1; // move to next day
                loadCapacity = arr[i]; // load the weight
            }else {
                // load the weight on the same day
                loadCapacity += arr[i];
            }
        }
        return days;
    }

    static int leastWeightCapacity(int []arr,int days){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i< arr.length;i++){
            if(arr[i] > max) {
                max = arr[i];
            }
            sum = sum + arr[i];
        }
        int low = max;
        int high = sum;
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int daysRequired = findDays(arr,mid);
            if(daysRequired <= days){
                high = mid - 1;
                ans = mid;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
