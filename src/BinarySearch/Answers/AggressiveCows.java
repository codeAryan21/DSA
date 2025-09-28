package BinarySearch.Answers;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int []stalls = {0, 3, 4, 7, 10, 9};
        int cows = 4;
        int ans = aggressiveCows(stalls, cows);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }

    static boolean canWePlace(int []stalls,int distance,int cows){
        int countCows = 1; // no. of cows placed
        int lastCow = stalls[0]; // position of last placed cow
        for (int i=1;i<stalls.length;i++){
            if(stalls[i] - lastCow >= distance){
                countCows++; // place next cow
                lastCow = stalls[i]; // update position of last placed cow
            }
            if(countCows >= cows){
                return true;
            }
        }
        return false;
    }

    static int aggressiveCows(int []arr,int cows){
        int n = arr.length;
        Arrays.sort(arr); // sort the array
        int low = 1;
        int high = arr[n-1] - arr[0];
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            boolean possible = canWePlace(arr,mid,cows);
            if(possible == true){
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
