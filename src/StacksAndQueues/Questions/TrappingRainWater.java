package StacksAndQueues.Questions;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public static void main(String[] args) {
        int []arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The total water that is trapped is: " + trappedWater(arr));
    }

    static int trappedWater(int []arr){
        int left = 0;
        int right = arr.length-1;
        int total = 0, leftMax = 0, rightMax = 0;
        while (left < right){
            // if left is lesser than right we deal with left because we want smaller one
            if(arr[left] <= arr[right]){
                if(leftMax > arr[left]){
                    total += leftMax - arr[left];
                }else {
                    leftMax = arr[left];
                }
                left++;
            }else {
                // else we deal with right because we want smaller one
                if(rightMax > arr[right]){
                    total += rightMax - arr[right];
                }else {
                    rightMax = arr[right];
                }
                right--;
            }
        }
        return total;
    }

    /*
    static int[] prefixMax(int []arr){
        int []prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = Math.max(prefix[i-1] ,arr[i]);
        }
        return prefix;
    }

    static int[] suffixMax(int []arr){
        int []suffix = new int[arr.length];
        suffix[suffix.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i+1] ,arr[i]);
        }
        return suffix;
    }

    static int trappedWater(int []arr){
        int total = 0;
        int []lMax = prefixMax(arr);
        int []rMax = suffixMax(arr);
        for(int i=0;i<arr.length;i++){
            int leftMax = lMax[i];
            int rightMax = rMax[i];
            if(arr[i] < leftMax && arr[i] < rightMax){
                total += Math.min(leftMax,rightMax) - arr[i];
            }
        }
        return total;
    }
     */
}
