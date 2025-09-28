package Array.Hard;

// https://leetcode.com/problems/maximum-product-subarray/description/?envType=problem-list-v2&envId=array
public class MaximumProductSubArray {
    public static void main(String[] args) {
        int []arr = {-3,3,4,-1,0,-2,3,1,-9,0,4,6,-1,4};
        System.out.print("The maximum product of the subArray is : " +  maxProduct(arr));
    }

    static int maxProduct(int []arr){
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[arr.length-i-1];
            max = Math.max(max, Math.max(prefix,suffix));
        }
        return max;
    }
}
