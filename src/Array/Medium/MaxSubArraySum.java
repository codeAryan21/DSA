package Array.Medium;

// https://leetcode.com/problems/maximum-subarray/description/?envType=problem-list-v2&envId=array
public class MaxSubArraySum {
    public static void main(String[] args) {
        int []arr = {4,-1,-5,-2,5,-1,5,-6,8,5};
        System.out.println("The maximum subarray sum is: " + maxSubArraySum(arr));
    }
    static int maxSubArraySum(int []arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < arr.length; i++) {
            // starting index
            if (sum == 0) start = i;

            sum += arr[i];
            if (sum > max){
                max = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if(sum < 0){
                sum = 0;
            }
        }
        // printing the subarray
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
        // To consider the sum of the empty subarray
        // uncomment the following check:
        // if (maxi < 0) maxi = 0;

        return max;
    }
}
