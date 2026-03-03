package TwoPointers.Medium;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int []arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
//        System.out.println("The max length of consecutive ones after flipping kth zeroes in the array is: " + longestOnes(arr,k));
        System.out.println("The max length of consecutive ones after flipping kth zeroes in the array is: " + maxConsecutiveOnes(arr,k));
    }

    public static int maxConsecutiveOnes(int []arr,int k){
        int l = 0, r = 0, maxLength = 0, zeroes = 0;
        while(r < arr.length){
            if(arr[r] == 0){
                zeroes++;
            }
            // shrink window if zeroes > k
            while(zeroes > k){
                if(arr[l] == 0) zeroes--;
                l++;
            }
            if(zeroes <= k){
                int length = r - l + 1;
                maxLength = Math.max(maxLength,length);
            }
            r++;
        }
        return maxLength;
    }

    public static int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        for(int i=0;i<nums.length;i++){
            int zeores = 0;
            for(int j=i;j<nums.length;j++){
                if(nums[j] == 0){
                    zeores++;
                }
                if(zeores <= k){
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength,length);
                }else{
                    break;
                }
            }
        }
        return maxLength;
    }
}

// for the most optimal solution we only need to change the inner while loop of maxConsecutiveOnes function
// instead of while we use if that the only change we have to made
// if(zeroes  > k){
//     if(arr[l] == 0) zeroes--;
//     l++;
// }