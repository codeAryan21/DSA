package TwoPointers.Medium;

// https://leetcode.com/problems/binary-subarrays-with-sum/
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int []arr = {1,0,1,0,1};
        int goal = 2;
        System.out.println("The number of subArray whose sum is equal to given goal is: " + numSubarraysWithSum(arr,goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return goal(nums,goal) - goal(nums,goal - 1);
    }

    public static int goal(int []arr,int k){
        if(k < 0) return 0;
        int l = 0, r = 0, sum = 0, count = 0;
        while(r < arr.length){
            sum += arr[r];
            while(sum > k){
                sum -= arr[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
