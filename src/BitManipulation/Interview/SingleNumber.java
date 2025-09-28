package BitManipulation.Interview;

// https://leetcode.com/problems/single-number/
public class SingleNumber {
    public static void main(String[] args) {
        int []arr = {4,1,2,1,2};
        System.out.println("Single number in the array is: " + singleNumber(arr));
    }

    static int singleNumber(int []arr) {
        int xor = 0;
        for(int i=0;i<arr.length;i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }
}
