package TwoPointers.Medium;

// https://leetcode.com/problems/count-number-of-nice-subarrays/
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int []arr = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println("The number of subArrays with K odd numbers in the array is: " + numberOfSubarrays(arr,k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return countSubarrays(nums,k) - countSubarrays(nums, k - 1);
    }

    // convert this problem to binary subArrays with sum equals to k by doing the arr[number] % 2;
    public static int countSubarrays(int []arr,int k){
        int l = 0, r = 0, sum = 0, count = 0;
        while(r < arr.length){
            sum = sum + arr[r] % 2; // we convert the odd number to 1 and even number to 0;
            while(sum > k){
                sum = sum - arr[l] % 2;
                l++;
            }
            count = count + (r - l + 1);
            r++;
        }
        return count;
    }
}
