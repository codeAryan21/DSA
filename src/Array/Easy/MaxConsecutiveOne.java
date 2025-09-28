package Array.Easy;

// https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int []arr = {1,1,0,2,1,1,1,5,1,1,0,1};
        System.out.print("The maximum 1 in the given array is : " + maxConsecutiveOne(arr));
    }

    static int maxConsecutiveOne(int []arr){
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
        }
        return max;
    }
}
