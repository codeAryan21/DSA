package BitManipulation.Interview;

import java.util.Arrays;
// https://leetcode.com/problems/single-number-iii/
public class SingleNumber3 {
    public static void main(String[] args) {
        int []arr = {1,2,1,3,2,5};
        int []ans = singleNumber(arr);
        System.out.println("Single number in the array is: " + Arrays.toString(ans));
    }

    static int[] singleNumber(int []arr){
        // Calculate XOR of all numbers
        long xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        // we get the right most bit and everything else is 0
        // if there are two distinct number, minimum of 1 bit position which is different
        long rightMost = ((xor & (xor-1)) ^ xor); // xor & (-xor)

        // b1 -> all the 1st bit which are 1
        // b2 -> all the 1st bit which are 0
        int b1 = 0;
        int b2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & rightMost) != 0){
                b1 = b1 ^ arr[i];
            }else {
                b2 = b2 ^ arr[i];
            }
        }
        return new int[]{b1,b2};
    }
}
