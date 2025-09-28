package BinarySearch.Answers;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBanana {
    public static void main(String[] args) {
        int []arr = {3,6,7,11};
        int h = 8;
        System.out.println("Koko should eat at least " + minimumRateToEatBananas(arr,h) + " bananas/hr.");
        System.out.println();
        System.out.println("Koko should eat at least " + minRateToEatBananas(arr,h) + " bananas/hr.");
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

    static int calculateHours(int []arr,int hour){
        int totalHour = 0;
        // find total hours
        for (int i = 0; i < arr.length; i++) {
            totalHour += (int) Math.ceil((double) arr[i] / (double) hour);
        }
        return totalHour;
    }

    // Return the min integer K such that koko can eat all bananas within h hours.
    static int minimumRateToEatBananas(int []arr,int h){
        int low = 0;
        int high = findMax(arr);
        int ans = Integer.MIN_VALUE;

        while (low <= high){
            int mid = low + (high - low) / 2;
            int totalHour = calculateHours(arr,mid);
            if(totalHour <= h){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return ans; // or low because both were at same place
    }

    static int minRateToEatBananas(int []arr,int h){
        int max = findMax(arr);
        for (int i = 1; i <= max; i++) {
            int reqTime = calculateHours(arr,i);
            if(reqTime <= h){
                return i;
            }
        }
        return max;
    }
}
