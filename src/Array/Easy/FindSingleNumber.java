package Array.Easy;

// https://leetcode.com/problems/single-number/
public class FindSingleNumber {
    public static void main(String[] args) {
        int []arr = {1,1,2,2,3,4,4,5,5};
        System.out.print("The number that appears one time is : " + singleNumber(arr));
    }

    // T.C:- O(N) , S.C:-O(1)
    static int singleNumber(int []arr){
        // XOR all the elements:
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        return xor;
    }
}
