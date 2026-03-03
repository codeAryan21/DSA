package TwoPointers.Medium;

// https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
public class RemovingMaxAndMin {
    public static void main(String[] args) {
        int []arr = {2,10,7,5,4,1,8,6};
        System.out.println("The minimum number of steps required to delete both maximum and minimum element from array is: " + minimumDeletions(arr));
    }
    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIdx = 0, maxIdx = 0;

        // first get the max, min and their indexes
        for(int i=0;i<n;i++){
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i; // for the above example maxIdx = 1
            }
            if(nums[i] < min){
                min = nums[i];
                minIdx = i; // for the above example minIdx = 5
            }
        }

        // Case 1: delete from left
        int left = Math.max(minIdx, maxIdx) + 1; // 5 + 1 = 6

        // Case 2: delete from right
        int right = n - Math.min(minIdx, maxIdx); // 8 - 1 = 7

        // Case 3: delete one from left and one from right
        int both = (Math.min(minIdx, maxIdx) + 1) + (n - Math.max(minIdx, maxIdx)); // [(1 + 1) + (8 - 5)] => 2 + 3 = 5

        int minSteps = Math.min(left, Math.min(right, both)); // min(6,min(7,5)) => min(6,5) => 5
        return minSteps;
    }
}
